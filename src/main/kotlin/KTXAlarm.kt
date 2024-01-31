import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.request.SendMessage
import org.jsoup.Jsoup
import org.jsoup.nodes.Element

class KTXAlarm {
    fun sendKtxAlarm(ticket: KTXTicket, ktxHttpRequest: CustomHttpRequest) {
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
        val res = table.map {
            TrainInfo(
                parseTimeNumber(it, telegramBot),
                isKtx(it.child(1)),
                !isAvailableReservation(it.child(4)),
                !isAvailableReservation(it.child(5))
            )
        }.filter {
            it.startTime in ktxTicket.startTime..ktxTicket.endTime
                && !it.isNormalSoldOut
                && (!ktxTicket.isOnlyKtxOrSRT || it.isKtx)
        }

        return res
    }

    data class TrainInfo(
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
        return element.toString().contains("KTX").or(element.toString().contains("SRT"))
    }

    fun isAvailableReservation(element: Element): Boolean {
        return element.toString().contains("예약하기") || element.toString().contains("좌석선택")
    }
}