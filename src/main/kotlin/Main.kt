import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.request.SendMessage
import kotlinx.coroutines.runBlocking
import org.jsoup.Jsoup
import org.jsoup.nodes.Element

const val TELEGRAM_BOT_TOKEN = "5930610065:AAGn-Rls4_wxzO1cU6cOmD3oR0gaohX6ay4"

const val MEGABOX_CLIENT_CHAT_ID = "-1001820329036"
const val KTX_CLIENT_CHAT_ID = "-947068919"

const val ADMIN_CHAT_ID = "1052011050"
const val KTX_URL = "https://www.letskorail.com/ebizprd/EbizPrdTicketPr21111_i1.do"
const val CHUNG_RYANG_RI_TO_ANDONG_URL =
    "txtGoStartCode=0090&txtGoEndCode=0526&radJobId=1&selGoTrain=05&txtSeatAttCd_4=015&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtPsgFlg_2=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&chkCpn=N&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=1&txtPsgCnt2=0&txtGoPage=1&txtGoAbrdDt=20230928&selGoRoom=&useSeatFlg=&useServiceFlg=&checkStnNm=Y&txtMenuId=11&SeandYo=&txtGoStartCode2=&txtGoEndCode2=&hidEasyTalk=&txtGoStart=%EC%B2%AD%EB%9F%89%EB%A6%AC&txtGoEnd=%EC%95%88%EB%8F%99&start=2023.9.28&selGoHour=00&txtGoHour=000000&selGoYear=2023&selGoMonth=09&selGoDay=28&txtGoYoil=%EB%AA%A9&txtPsgFlg_1=1"
const val SEOUL_TO_EAST_DAEGU_FIRST_URL =
    "&txtGoAbrdDt=20230927&txtGoHour=084800&selGoYear=2023&selGoMonth=09&selGoDay=27&selGoHour=00&txtGoPage=2&txtGoStartCode=0001&txtGoStart=%EC%84%9C%EC%9A%B8&txtGoEndCode=0015&txtGoEnd=%EB%8F%99%EB%8C%80%EA%B5%AC&selGoTrain=05&selGoRoom=&selGoRoom1=&txtGoTrnNo=&useSeatFlg=&useServiceFlg=&selGoSeat=&selGoService=&txtPnrNo=&hidRsvChgNo=&hidStlFlg=&radJobId=1&SeandYo=&hidRsvTpCd=03&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=1&txtPsgCnt2=0&txtMenuId=11&txtPsgFlg_1=1&txtPsgFlg_2=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&txtPsgFlg_8=0&chkCpn=N&txtSeatAttCd_4=015&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtGoStartCode2=&txtGoEndCode2=&hidDiscount=&hidEasyTalk=&adjcCheckYn=N"
const val SEOUL_TO_EAST_DAEGU_SECOND_URL =
    "&txtGoAbrdDt=20230927&txtGoHour=095700&selGoYear=2023&selGoMonth=09&selGoDay=27&selGoHour=00&txtGoPage=2&txtGoStartCode=0001&txtGoStart=%EC%84%9C%EC%9A%B8&txtGoEndCode=0015&txtGoEnd=%EB%8F%99%EB%8C%80%EA%B5%AC&selGoTrain=05&selGoRoom=&selGoRoom1=&txtGoTrnNo=&useSeatFlg=&useServiceFlg=&selGoSeat=&selGoService=&txtPnrNo=&hidRsvChgNo=&hidStlFlg=&radJobId=1&SeandYo=&hidRsvTpCd=03&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=1&txtPsgCnt2=0&txtMenuId=11&txtPsgFlg_1=1&txtPsgFlg_2=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&txtPsgFlg_8=0&chkCpn=N&txtSeatAttCd_4=015&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtGoStartCode2=&txtGoEndCode2=&hidDiscount=&hidEasyTalk=&adjcCheckYn=N"
const val SEOUL_TO_EAST_DAEGU_THIRD_URL =
    "&txtGoAbrdDt=20230927&txtGoHour=104700&selGoYear=2023&selGoMonth=09&selGoDay=27&selGoHour=00&txtGoPage=2&txtGoStartCode=0001&txtGoStart=%EC%84%9C%EC%9A%B8&txtGoEndCode=0015&txtGoEnd=%EB%8F%99%EB%8C%80%EA%B5%AC&selGoTrain=05&selGoRoom=&selGoRoom1=&txtGoTrnNo=&useSeatFlg=&useServiceFlg=&selGoSeat=&selGoService=&txtPnrNo=&hidRsvChgNo=&hidStlFlg=&radJobId=1&SeandYo=&hidRsvTpCd=03&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=1&txtPsgCnt2=0&txtMenuId=11&txtPsgFlg_1=1&txtPsgFlg_2=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&txtPsgFlg_8=0&chkCpn=N&txtSeatAttCd_4=015&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtGoStartCode2=&txtGoEndCode2=&hidDiscount=&hidEasyTalk=&adjcCheckYn=N"


enum class KTXTicket(
    val targetName: String,
    val startTime: Int,
    val endTime: Int,
    val url: String,
    val isOnlyKtx: Boolean
) {
    CHUNG_RYANG_RI_TO_ANDONG("청량리에서 안동", 900, 1800, CHUNG_RYANG_RI_TO_ANDONG_URL, false),
    SEOUL_TO_EAST_DAEGU_FIRST("서울에서 동대구", 910, 1130, SEOUL_TO_EAST_DAEGU_FIRST_URL, true),
    SEOUL_TO_EAST_DAEGU_SECOND("서울에서 동대구", 910, 1130, SEOUL_TO_EAST_DAEGU_SECOND_URL, true),
    SEOUL_TO_EAST_DAEGU_THIRD("서울에서 동대구", 910, 1130, SEOUL_TO_EAST_DAEGU_THIRD_URL, true)
}

val telegramBot = TelegramBot(TELEGRAM_BOT_TOKEN)
fun main() {
    val ktxHttpRequest = KtxHttpRequest()
    val startRequest = SendMessage(ADMIN_CHAT_ID, "서버 시작")
    val serverHealthRequest = SendMessage(ADMIN_CHAT_ID, "서버 정상")
    telegramBot.execute(startRequest)
    var count = 0
    while (true) {
        runBlocking {
            sendAlarm(KTXTicket.CHUNG_RYANG_RI_TO_ANDONG, ktxHttpRequest)
            sendAlarm(KTXTicket.SEOUL_TO_EAST_DAEGU_FIRST, ktxHttpRequest)
            sendAlarm(KTXTicket.SEOUL_TO_EAST_DAEGU_SECOND, ktxHttpRequest)
            sendAlarm(KTXTicket.SEOUL_TO_EAST_DAEGU_THIRD, ktxHttpRequest)
        }
        Thread.sleep(1000)
        count++
        if (count > 3600) {
            telegramBot.execute(serverHealthRequest)
            count = 0
        }
    }
}

suspend fun sendAlarm(ticket: KTXTicket, ktxHttpRequest: CustomHttpRequest) {
    val html = ktxHttpRequest.sendRequest(KTX_URL, ticket.url)
    val remainTrainInfoList = getRemainTrainInfoList(html, ticket)

    remainTrainInfoList.forEach {
        val request = SendMessage(KTX_CLIENT_CHAT_ID, "${ticket.targetName} ${it.startTime}")
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

