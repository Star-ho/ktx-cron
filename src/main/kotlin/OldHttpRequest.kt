import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class OldHttpRequest {
    fun request(): String? {
        val client: HttpClient = HttpClient.newHttpClient()

        val request: HttpRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://www.letskorail.com/ebizprd/EbizPrdTicketPr21111_i1.do?&txtGoAbrdDt=20230927&txtGoHour=101100&selGoYear=2023&selGoMonth=09&selGoDay=27&selGoHour=09&txtGoPage=2&txtGoStartCode=0001&txtGoStart=%EC%84%9C%EC%9A%B8&txtGoEndCode=0015&txtGoEnd=%EB%8F%99%EB%8C%80%EA%B5%AC&selGoTrain=05&selGoRoom=&selGoRoom1=&txtGoTrnNo=&useSeatFlg=&useServiceFlg=&selGoSeat=&selGoService=&txtPnrNo=&hidRsvChgNo=&hidStlFlg=&radJobId=1&SeandYo=&hidRsvTpCd=03&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=1&txtPsgCnt2=0&txtMenuId=11&txtPsgFlg_1=1&txtPsgFlg_2=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&txtPsgFlg_8=&chkCpn=N&txtSeatAttCd_4=015&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtGoStartCode2=&txtGoEndCode2=&hidDiscount=&hidEasyTalk=&adjcCheckYn=N"))
            .POST(HttpRequest.BodyPublishers.ofString("selGoYear=2023&selGoMonth=09&selGoDay=27&selGoHour=09"))
            .setHeader(
                "Accept",
                "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"
            )
            .setHeader("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
            .setHeader("Cache-Control", "no-cache")
            .setHeader("Content-Type", "application/x-www-form-urlencoded")
            .setHeader(
                "Cookie",
                "_ga=GA1.1.94426194.1693289287; WMONID=DlrXqs-eDe1; saveMember=; NetFunnel_ID=; NF_KEY=; JSESSIONID=VHHBRIkhuoy2thr0zlwbXBIPNTCusJkYawgrTu3Gtu56KwMMxnRy0rI8WHKvK6sh.kr029_servlet_engine4; _ga_LP2TSNTFG1=GS1.1.1693541919.7.1.1693541935.0.0.0"
            )
            .setHeader("Origin", "https://www.letskorail.com")
            .setHeader("Pragma", "no-cache")
            .setHeader("Referer", "https://www.letskorail.com/ebizprd/EbizPrdTicketPr21111_i1.do")
            .setHeader("Sec-Fetch-Dest", "document")
            .setHeader("Sec-Fetch-Mode", "navigate")
            .setHeader("Sec-Fetch-Site", "same-origin")
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
}