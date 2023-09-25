import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jsonMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.request.SendMessage
import org.jsoup.Jsoup
import org.jsoup.nodes.Element

const val TELEGRAM_BOT_TOKEN = "5930610065:AAGn-Rls4_wxzO1cU6cOmD3oR0gaohX6ay4"

const val MEGABOX_CLIENT_CHAT_ID = "-1001820329036"
const val KTX_CLIENT_CHAT_ID = "-947068919"

const val ADMIN_CHAT_ID = "1052011050"
const val KTX_URL = "https://www.letskorail.com/ebizprd/EbizPrdTicketPr21111_i1.do"
const val CHUNG_RYANG_RI_TO_ANDONG_URL =
    "txtGoStartCode=0090&txtGoEndCode=0526&radJobId=1&selGoTrain=05&txtSeatAttCd_4=015&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtPsgFlg_2=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&chkCpn=N&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=1&txtPsgCnt2=0&txtGoPage=1&txtGoAbrdDt=20230928&selGoRoom=&useSeatFlg=&useServiceFlg=&checkStnNm=Y&txtMenuId=11&SeandYo=&txtGoStartCode2=&txtGoEndCode2=&hidEasyTalk=&txtGoStart=%EC%B2%AD%EB%9F%89%EB%A6%AC&txtGoEnd=%EC%95%88%EB%8F%99&start=2023.9.28&selGoHour=00&txtGoHour=000000&selGoYear=2023&selGoMonth=09&selGoDay=28&txtGoYoil=%EB%AA%A9&txtPsgFlg_1=1"

const val SINLIM_ATHLETIC_CENTER_LECTURE_URL =
    "https://www.gwanakgongdan.or.kr/rest/lecture/list?company_code=KWAN_AK02&search_type=R&category_cd=1000010000&category_level=2&page=1&page_size=100"

enum class KTXTicket(
    val targetName: String,
    val startTime: Int,
    val endTime: Int,
    val url: String,
    val isOnlyKtx: Boolean
) {
    CHUNG_RYANG_RI_TO_ANDONG("청량리에서 안동", 900, 1800, CHUNG_RYANG_RI_TO_ANDONG_URL, false),
}

val telegramBot = TelegramBot(TELEGRAM_BOT_TOKEN)
fun main() {
    val ktxHttpRequest = OldHttpRequest()
    val startRequest = SendMessage(ADMIN_CHAT_ID, "서버 시작 v8")
    val objectMapper = jsonMapper()
        .registerModules(kotlinModule())
    telegramBot.execute(startRequest)
    var count = 0
    while (true) {
        println("sendKtx")
        sendKtxAlarm(KTXTicket.CHUNG_RYANG_RI_TO_ANDONG, ktxHttpRequest)
        println("sendSwim")
        sendSwimAlarm(objectMapper)

        count++
        if (count > 3600) {
            val serverHealthRequest = SendMessage(ADMIN_CHAT_ID, "서버 정상")
            telegramBot.execute(serverHealthRequest)
            count = 0
        }
    }
}

fun sendSwimAlarm(objectMapper: ObjectMapper) {
    val response = SinlimSwimHttpRequest().sendRequest(SINLIM_ATHLETIC_CENTER_LECTURE_URL, objectMapper)
    val remainLectureList = response
        .filter { it.capa.toInt() - it.reg_person.toInt() > 0 }
        .filter { (it.class_cd == "00038" || it.class_cd == "00046") }

    remainLectureList.forEach {
        val request = SendMessage(MEGABOX_CLIENT_CHAT_ID, "${it.comnm} ${it.train_day_nm}  ${it.train_stime}")
        telegramBot.execute(request)
    }
}

fun sendKtxAlarm(ticket: KTXTicket, ktxHttpRequest: CustomHttpRequest) {
    val html = ktxHttpRequest.sendRequest(KTX_URL, ticket.url)
    val remainTrainInfoList = getRemainTrainInfoList(html, ticket)

    remainTrainInfoList.forEach {
        val request = SendMessage(MEGABOX_CLIENT_CHAT_ID, "${ticket.targetName} ${it.startTime}")
        telegramBot.execute(request)
    }
}

fun getRemainTrainInfoList(html: String, ktxTicket: KTXTicket): List<TrainInfo> {

    val document = Jsoup.parse(html)
    // tr의 index
    // 구분	열차  번호 출발시각 도착시각 정렬	특실/우등실 일반실 유아 자유석/입석	인터넷특가 예약 정차역 차량유형 운임 소요시간
    val table = document.select("#tableResult > tbody > tr")
    return table.map {
        TrainInfo(
            parseTimeNumber(it, telegramBot),
            isKtx(it.child(1)),
            isSoldOut(it.child(4)),
            isSoldOut(it.child(5))
        )
    }.filter {
        it.startTime in ktxTicket.startTime..ktxTicket.endTime && !it.isNormalSoldOut
                && (!ktxTicket.isOnlyKtx || it.isKtx)
    }
}

class TrainInfo(
    val startTime: Int,
    val isKtx: Boolean,
    val isSpecialSoldOut: Boolean,
    val isNormalSoldOut: Boolean
)

fun parseTimeNumber(element: Element, telegramBot: TelegramBot): Int {
    runCatching {
        val stringToTimeRegex = "[0-9][0-9]:[0-9][0-9]".toRegex()
        val startTimeString = element.child(2).toString()

        val timeString = stringToTimeRegex.find(startTimeString)!!.value

        val timeToNumberRegex = "[0-9]".toRegex()
        return timeToNumberRegex.findAll(timeString).joinToString("") { str -> str.value }.toInt()
    }.onFailure {
        sendError(telegramBot, "날짜 파싱 에러")
    }
    return 0
}

fun sendError(telegramBot: TelegramBot, errMsg: String) {
    val request = SendMessage(ADMIN_CHAT_ID, errMsg)
    telegramBot.execute(request)
}

fun isKtx(element: Element): Boolean {
    return element.toString().contains("KTX")
}

fun isSoldOut(element: Element): Boolean {
    return element.toString().contains("매진")
}

