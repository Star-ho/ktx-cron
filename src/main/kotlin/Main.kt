import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.request.SendMessage
import org.jsoup.Jsoup
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers
import java.net.http.HttpResponse

const val TELEGRAM_BOT_TOKEN = "5930610065:AAGn-Rls4_wxzO1cU6cOmD3oR0gaohX6ay4"

const val HEALTH_CHECK_CHAT_ID = "-1001820329036"
const val SEND_DATA_CHAT_ID = "-1001820329036"

fun main() {
    val html = getHtml()!!
    val jsop = Jsoup.parse(html)
    // tr의 index
    // 구분	열차  번호	출발  출발시각 도착시각 정렬	특실/우등실 일반실 유아 자유석/입석	인터넷특가 예약 정차역 차량유형 운임 소요시간
    val table = jsop.select("#tableResult > tbody > tr")
    table.forEach {
        // 출발시간
        println(it.child(2))
        // 특실
        println(it.child(4))
        // 일반실
        println(it.child(5))
    }

    val telegramBot = TelegramBot(TELEGRAM_BOT_TOKEN)

    val request = SendMessage(SEND_DATA_CHAT_ID,"서버정상")

    val res = telegramBot.execute(request)
    println(res)
//    #tableResult > tbody > tr:nth-child(1) > td:nth-child(6)
}

fun getHtml(): String? {
    val client = HttpClient.newHttpClient()

    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.letskorail.com/ebizprd/EbizPrdTicketPr21111_i1.do"))
        .POST(BodyPublishers.ofString("txtGoStartCode=0090&txtGoEndCode=0526&radJobId=1&selGoTrain=05&txtSeatAttCd_4=015&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtPsgFlg_2=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&chkCpn=N&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=1&txtPsgCnt2=0&txtGoPage=1&txtGoAbrdDt=20230928&selGoRoom=&useSeatFlg=&useServiceFlg=&checkStnNm=Y&txtMenuId=11&SeandYo=&txtGoStartCode2=&txtGoEndCode2=&hidEasyTalk=&txtGoStart=%EC%B2%AD%EB%9F%89%EB%A6%AC&txtGoEnd=%EC%95%88%EB%8F%99&start=2023.9.28&selGoHour=00&txtGoHour=000000&selGoYear=2023&selGoMonth=09&selGoDay=28&txtGoYoil=%EB%AA%A9&txtPsgFlg_1=1"))
        .setHeader(
            "Accept",
            "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"
        )
        .setHeader("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
        .setHeader("Cache-Control", "no-cache")
        .setHeader("Content-Type", "application/x-www-form-urlencoded")
        .setHeader(
            "Cookie",
            "_ga=GA1.1.94426194.1693289287; WMONID=DlrXqs-eDe1; saveMember=; NetFunnel_ID=; NF_KEY=; JSESSIONID=cS40SKZ9HE0Q1EhkSIa453YT54YUgYN7ou0RtX5zi6oWQsCVxaA86TbVVrpiAsrw.kr008_servlet_engine2; _ga_LP2TSNTFG1=GS1.1.1693491464.5.1.1693491836.0.0.0"
        )
        .setHeader("Origin", "https://www.letskorail.com")
        .setHeader("Pragma", "no-cache")
        .setHeader("Referer", "https://www.letskorail.com/")
        .setHeader("Sec-Fetch-Dest", "document")
        .setHeader("Sec-Fetch-Mode", "navigate")
        .setHeader("Sec-Fetch-Site", "same-origin")
        .setHeader("Sec-Fetch-User", "?1")
        .setHeader("Upgrade-Insecure-Requests", "1")
        .setHeader(
            "User-Agent",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36"
        )
        .setHeader("sec-ch-ua", "\"Not/A)Brand\";v=\"99\", \"Google Chrome\";v=\"115\", \"Chromium\";v=\"115\"")
        .setHeader("sec-ch-ua-mobile", "?0")
        .setHeader("sec-ch-ua-platform", "\"macOS\"")
        .build()

    return client.send(request, HttpResponse.BodyHandlers.ofString()).body()
}