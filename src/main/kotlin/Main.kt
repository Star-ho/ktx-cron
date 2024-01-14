import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.request.SendMessage
import java.util.concurrent.Executors

const val TELEGRAM_BOT_TOKEN = "5930610065:AAGn-Rls4_wxzO1cU6cOmD3oR0gaohX6ay4"

const val MEGABOX_CLIENT_CHAT_ID = "-1001820329036"
const val KTX_CLIENT_CHAT_ID = "-947068919"

const val ADMIN_CHAT_ID = "1052011050"
const val KTX_URL = "https://www.letskorail.com/ebizprd/EbizPrdTicketPr21111_i1.do"

const val DONGDAEGO_TO_SEOUL_14_FIRST =
    "hidNormalRsv=&hidBiztransferRsv=&srTOrder=&hidDiscount=&selGoTrain=05&txtPsgFlg_1=1&txtPsgFlg_2=0&txtPsgFlg_8=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtSeatAttCd_4=015&selGoTrainRa=05&radJobId=1&adjcCheckYn=Y&txtGoStart=%EC%84%9C%EC%9A%B8&txtGoEnd=%EB%8F%99%EB%8C%80%EA%B5%AC&txtGoStartCode=&txtGoEndCode=&selGoYear=2024&selGoMonth=02&selGoDay=08&selGoHour=13&txtGoHour=130000&txtGoYoil=%EB%AA%A9&ret_url=&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=1&txtPsgCnt2=0&txtGoPage=1&txtGoAbrdDt=20240208&selGoRoom=&useSeatFlg=&useServiceFlg=&checkStnNm=Y&SeandYo=N&txtGoStartCode2=&txtGoEndCode2=&txtPnrNo=&hidStlFlg=&chkTrnSeq=&chkChgTrn1=&chkChgTrn2=&chkBtnImgTrn1=&chkBtnImgTrn2=&chkInitFlg=Y&txtMenuId=11&ra=1&txtSeatAttCd1=&txtSeatAttCd2=&txtSeatAttCd3=&txtSeatAttCd4=&txtSeatAttCd4_1=&txtSeatAttCd5=&strChkCpn=N&txtTotPsgCnt=&txtSrcarCnt=0&txtSrcarCnt1=0&txtSrcarNo1=&txtSrcarNo2=&txtSrcarNo3=&txtSrcarNo4=&txtSrcarNo5=&txtSrcarNo6=&txtSrcarNo7=&txtSrcarNo8=&txtSrcarNo9=&txtSeatNo1=&txtSeatNo2=&txtSeatNo3=&txtSeatNo4=&txtSeatNo5=&txtSeatNo6=&txtSeatNo7=&txtSeatNo8=&txtSeatNo9=&txtSrcarNo1_1=&txtSrcarNo1_2=&txtSrcarNo1_3=&txtSrcarNo1_4=&txtSrcarNo1_5=&txtSrcarNo1_6=&txtSrcarNo1_7=&txtSrcarNo1_8=&txtSrcarNo1_9=&txtSeatNo1_1=&txtSeatNo1_2=&txtSeatNo1_3=&txtSeatNo1_4=&txtSeatNo1_5=&txtSeatNo1_6=&txtSeatNo1_7=&txtSeatNo1_8=&txtSeatNo1_9=&txtDmdSeatAtt1=&txtDmdSeatAtt2=&txtDmdSeatAtt3=&txtDmdSeatAtt4=&txtDmdSeatAtt5=&txtDmdSeatAtt6=&txtDmdSeatAtt7=&txtDmdSeatAtt8=&txtDmdSeatAtt9=&txtDmdSeatAtt1_1=&txtDmdSeatAtt1_2=&txtDmdSeatAtt1_3=&txtDmdSeatAtt1_4=&txtDmdSeatAtt1_5=&txtDmdSeatAtt1_6=&txtDmdSeatAtt1_7=&txtDmdSeatAtt1_8=&txtDmdSeatAtt1_9=&hidRsvChgNo=&hidRsvTpCd=03&txtPsgTpCd1=1&txtPsgTpCd2=3&txtPsgTpCd3=1&txtPsgTpCd4=&txtPsgTpCd5=1&txtPsgTpCd6=&txtPsgTpCd7=1&txtPsgTpCd8=3&txtPsgTpCd9=&txtDiscKndCd1=000&txtDiscKndCd2=000&txtDiscKndCd3=111&txtDiscKndCd4=&txtDiscKndCd5=131&txtDiscKndCd6=&txtDiscKndCd7=112&txtDiscKndCd8=321&txtDiscKndCd9=&txtCompaCnt1=0&txtCompaCnt2=0&txtCompaCnt3=0&txtCompaCnt4=0&txtCompaCnt5=0&txtCompaCnt6=0&txtCompaCnt7=0&txtCompaCnt8=0&txtCompaCnt9=&txtStndFlg=&txtJobId=&txtJrnyCnt=&txtDptStnConsOrdr1=&txtArvStnConsOrdr1=&txtDptStnRunOrdr1=&txtArvStnRunOrdr1=&txtDptStnConsOrdr2=&txtArvStnConsOrdr2=&txtDptStnRunOrdr2=&txtArvStnRunOrdr2=&txtPsrmClCd1=&txtJrnySqno1=&txtJrnyTpCd1=&txtDptDt1=&txtDptRsStnCd1=&txtDptRsStnCdNm1=&txtDptTm1=&txtArvRsStnCd1=&txtArvRsStnCdNm1=&txtArvTm1=&txtTrnNo1=&txtRunDt1=&txtTrnClsfCd1=&txtTrnGpCd1=&txtChgFlg1=&txtDoTrnFlg1=&txtPsrmClCd2=&txtJrnySqno2=&txtJrnyTpCd2=&txtDptDt2=&txtDptRsStnCd2=&txtDptRsStnCdNm2=&txtDptTm2=&txtArvRsStnCd2=&txtArvRsStnCdNm2=&txtArvTm2=&txtTrnNo2=&txtRunDt2=&txtTrnClsfCd2=&txtTrnGpCd2=&txtChgFlg2=&txtDoTrnFlg2=&selGoStartDay=&strHmac=&PageInx=&hidEasyTalk=&hidCapFlag="

const val DONGDAEGO_TO_SEOUL_14_SECOND =
    "&txtGoAbrdDt=20240208&txtGoHour=141800&selGoYear=2024&selGoMonth=02&selGoDay=08&selGoHour=13&txtGoPage=2&txtGoStartCode=0001&txtGoStart=%EC%84%9C%EC%9A%B8&txtGoEndCode=0015&txtGoEnd=%EB%8F%99%EB%8C%80%EA%B5%AC&selGoTrain=05&selGoRoom=&selGoRoom1=&txtGoTrnNo=&useSeatFlg=&useServiceFlg=&selGoSeat=&selGoService=&txtPnrNo=&hidRsvChgNo=&hidStlFlg=&radJobId=1&SeandYo=&hidRsvTpCd=03&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=1&txtPsgCnt2=0&txtMenuId=11&txtPsgFlg_1=1&txtPsgFlg_2=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&txtPsgFlg_8=0&chkCpn=N&txtSeatAttCd_4=015&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtGoStartCode2=&txtGoEndCode2=&hidDiscount=&hidEasyTalk=&adjcCheckYn=Y\n"

const val DONGDAEGO_TO_SEOUL_14_THRID =
    "&txtGoAbrdDt=20240208&txtGoHour=152200&selGoYear=2024&selGoMonth=02&selGoDay=08&selGoHour=13&txtGoPage=2&txtGoStartCode=0001&txtGoStart=%EC%84%9C%EC%9A%B8&txtGoEndCode=0015&txtGoEnd=%EB%8F%99%EB%8C%80%EA%B5%AC&selGoTrain=05&selGoRoom=&selGoRoom1=&txtGoTrnNo=&useSeatFlg=&useServiceFlg=&selGoSeat=&selGoService=&txtPnrNo=&hidRsvChgNo=&hidStlFlg=&radJobId=1&SeandYo=&hidRsvTpCd=03&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=1&txtPsgCnt2=0&txtMenuId=11&txtPsgFlg_1=1&txtPsgFlg_2=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&txtPsgFlg_8=0&chkCpn=N&txtSeatAttCd_4=015&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtGoStartCode2=&txtGoEndCode2=&hidDiscount=&hidEasyTalk=&adjcCheckYn=Y\n"

const val DONGDAEGO_TO_SEOUL_18_FIRST =
    "hidNormalRsv=&hidBiztransferRsv=&srTOrder=&hidDiscount=&selGoTrain=05&txtPsgFlg_1=1&txtPsgFlg_2=0&txtPsgFlg_8=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtSeatAttCd_4=015&selGoTrainRa=05&radJobId=1&adjcCheckYn=Y&txtGoStart=%EC%84%9C%EC%9A%B8&txtGoEnd=%EB%8F%99%EB%8C%80%EA%B5%AC&txtGoStartCode=&txtGoEndCode=&selGoYear=2024&selGoMonth=02&selGoDay=08&selGoHour=18&txtGoHour=180000&txtGoYoil=%EB%AA%A9&ret_url=&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=1&txtPsgCnt2=0&txtGoPage=1&txtGoAbrdDt=20240208&selGoRoom=&useSeatFlg=&useServiceFlg=&checkStnNm=Y&SeandYo=N&txtGoStartCode2=&txtGoEndCode2=&txtPnrNo=&hidStlFlg=&chkTrnSeq=&chkChgTrn1=&chkChgTrn2=&chkBtnImgTrn1=&chkBtnImgTrn2=&chkInitFlg=Y&txtMenuId=11&ra=1&txtSeatAttCd1=&txtSeatAttCd2=&txtSeatAttCd3=&txtSeatAttCd4=&txtSeatAttCd4_1=&txtSeatAttCd5=&strChkCpn=N&txtTotPsgCnt=&txtSrcarCnt=0&txtSrcarCnt1=0&txtSrcarNo1=&txtSrcarNo2=&txtSrcarNo3=&txtSrcarNo4=&txtSrcarNo5=&txtSrcarNo6=&txtSrcarNo7=&txtSrcarNo8=&txtSrcarNo9=&txtSeatNo1=&txtSeatNo2=&txtSeatNo3=&txtSeatNo4=&txtSeatNo5=&txtSeatNo6=&txtSeatNo7=&txtSeatNo8=&txtSeatNo9=&txtSrcarNo1_1=&txtSrcarNo1_2=&txtSrcarNo1_3=&txtSrcarNo1_4=&txtSrcarNo1_5=&txtSrcarNo1_6=&txtSrcarNo1_7=&txtSrcarNo1_8=&txtSrcarNo1_9=&txtSeatNo1_1=&txtSeatNo1_2=&txtSeatNo1_3=&txtSeatNo1_4=&txtSeatNo1_5=&txtSeatNo1_6=&txtSeatNo1_7=&txtSeatNo1_8=&txtSeatNo1_9=&txtDmdSeatAtt1=&txtDmdSeatAtt2=&txtDmdSeatAtt3=&txtDmdSeatAtt4=&txtDmdSeatAtt5=&txtDmdSeatAtt6=&txtDmdSeatAtt7=&txtDmdSeatAtt8=&txtDmdSeatAtt9=&txtDmdSeatAtt1_1=&txtDmdSeatAtt1_2=&txtDmdSeatAtt1_3=&txtDmdSeatAtt1_4=&txtDmdSeatAtt1_5=&txtDmdSeatAtt1_6=&txtDmdSeatAtt1_7=&txtDmdSeatAtt1_8=&txtDmdSeatAtt1_9=&hidRsvChgNo=&hidRsvTpCd=03&txtPsgTpCd1=1&txtPsgTpCd2=3&txtPsgTpCd3=1&txtPsgTpCd4=&txtPsgTpCd5=1&txtPsgTpCd6=&txtPsgTpCd7=1&txtPsgTpCd8=3&txtPsgTpCd9=&txtDiscKndCd1=000&txtDiscKndCd2=000&txtDiscKndCd3=111&txtDiscKndCd4=&txtDiscKndCd5=131&txtDiscKndCd6=&txtDiscKndCd7=112&txtDiscKndCd8=321&txtDiscKndCd9=&txtCompaCnt1=0&txtCompaCnt2=0&txtCompaCnt3=0&txtCompaCnt4=0&txtCompaCnt5=0&txtCompaCnt6=0&txtCompaCnt7=0&txtCompaCnt8=0&txtCompaCnt9=&txtStndFlg=&txtJobId=&txtJrnyCnt=&txtDptStnConsOrdr1=&txtArvStnConsOrdr1=&txtDptStnRunOrdr1=&txtArvStnRunOrdr1=&txtDptStnConsOrdr2=&txtArvStnConsOrdr2=&txtDptStnRunOrdr2=&txtArvStnRunOrdr2=&txtPsrmClCd1=&txtJrnySqno1=&txtJrnyTpCd1=&txtDptDt1=&txtDptRsStnCd1=&txtDptRsStnCdNm1=&txtDptTm1=&txtArvRsStnCd1=&txtArvRsStnCdNm1=&txtArvTm1=&txtTrnNo1=&txtRunDt1=&txtTrnClsfCd1=&txtTrnGpCd1=&txtChgFlg1=&txtDoTrnFlg1=&txtPsrmClCd2=&txtJrnySqno2=&txtJrnyTpCd2=&txtDptDt2=&txtDptRsStnCd2=&txtDptRsStnCdNm2=&txtDptTm2=&txtArvRsStnCd2=&txtArvRsStnCdNm2=&txtArvTm2=&txtTrnNo2=&txtRunDt2=&txtTrnClsfCd2=&txtTrnGpCd2=&txtChgFlg2=&txtDoTrnFlg2=&selGoStartDay=&strHmac=&PageInx=&hidEasyTalk=&hidCapFlag="

const val DONGDAEGO_TO_SEOUL_18_SECOND =
    "&txtGoAbrdDt=20240208&txtGoHour=193400&selGoYear=2024&selGoMonth=02&selGoDay=08&selGoHour=18&txtGoPage=2&txtGoStartCode=0001&txtGoStart=%EC%84%9C%EC%9A%B8&txtGoEndCode=0015&txtGoEnd=%EB%8F%99%EB%8C%80%EA%B5%AC&selGoTrain=05&selGoRoom=&selGoRoom1=&txtGoTrnNo=&useSeatFlg=&useServiceFlg=&selGoSeat=&selGoService=&txtPnrNo=&hidRsvChgNo=&hidStlFlg=&radJobId=1&SeandYo=&hidRsvTpCd=03&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=1&txtPsgCnt2=0&txtMenuId=11&txtPsgFlg_1=1&txtPsgFlg_2=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&txtPsgFlg_8=0&chkCpn=N&txtSeatAttCd_4=015&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtGoStartCode2=&txtGoEndCode2=&hidDiscount=&hidEasyTalk=&adjcCheckYn=Y"

const val SEOUL_TO_MASAN_15 =
    "hidNormalRsv=&hidBiztransferRsv=&srTOrder=&hidDiscount=&selGoTrain=05&txtPsgFlg_1=1&txtPsgFlg_2=0&txtPsgFlg_8=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtSeatAttCd_4=015&selGoTrainRa=05&radJobId=1&adjcCheckYn=Y&txtGoStart=%EC%84%9C%EC%9A%B8&txtGoEnd=%EB%A7%88%EC%82%B0&txtGoStartCode=&txtGoEndCode=0059&selGoYear=2024&selGoMonth=02&selGoDay=08&selGoHour=15&txtGoHour=150000&txtGoYoil=%EB%AA%A9&ret_url=&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=1&txtPsgCnt2=0&txtGoPage=1&txtGoAbrdDt=20240208&selGoRoom=&useSeatFlg=&useServiceFlg=&checkStnNm=Y&SeandYo=N&txtGoStartCode2=&txtGoEndCode2=&txtPnrNo=&hidStlFlg=&chkTrnSeq=&chkChgTrn1=&chkChgTrn2=&chkBtnImgTrn1=&chkBtnImgTrn2=&chkInitFlg=Y&txtMenuId=11&ra=1&txtSeatAttCd1=&txtSeatAttCd2=&txtSeatAttCd3=&txtSeatAttCd4=&txtSeatAttCd4_1=&txtSeatAttCd5=&strChkCpn=N&txtTotPsgCnt=&txtSrcarCnt=0&txtSrcarCnt1=0&txtSrcarNo1=&txtSrcarNo2=&txtSrcarNo3=&txtSrcarNo4=&txtSrcarNo5=&txtSrcarNo6=&txtSrcarNo7=&txtSrcarNo8=&txtSrcarNo9=&txtSeatNo1=&txtSeatNo2=&txtSeatNo3=&txtSeatNo4=&txtSeatNo5=&txtSeatNo6=&txtSeatNo7=&txtSeatNo8=&txtSeatNo9=&txtSrcarNo1_1=&txtSrcarNo1_2=&txtSrcarNo1_3=&txtSrcarNo1_4=&txtSrcarNo1_5=&txtSrcarNo1_6=&txtSrcarNo1_7=&txtSrcarNo1_8=&txtSrcarNo1_9=&txtSeatNo1_1=&txtSeatNo1_2=&txtSeatNo1_3=&txtSeatNo1_4=&txtSeatNo1_5=&txtSeatNo1_6=&txtSeatNo1_7=&txtSeatNo1_8=&txtSeatNo1_9=&txtDmdSeatAtt1=&txtDmdSeatAtt2=&txtDmdSeatAtt3=&txtDmdSeatAtt4=&txtDmdSeatAtt5=&txtDmdSeatAtt6=&txtDmdSeatAtt7=&txtDmdSeatAtt8=&txtDmdSeatAtt9=&txtDmdSeatAtt1_1=&txtDmdSeatAtt1_2=&txtDmdSeatAtt1_3=&txtDmdSeatAtt1_4=&txtDmdSeatAtt1_5=&txtDmdSeatAtt1_6=&txtDmdSeatAtt1_7=&txtDmdSeatAtt1_8=&txtDmdSeatAtt1_9=&hidRsvChgNo=&hidRsvTpCd=03&txtPsgTpCd1=1&txtPsgTpCd2=3&txtPsgTpCd3=1&txtPsgTpCd4=&txtPsgTpCd5=1&txtPsgTpCd6=&txtPsgTpCd7=1&txtPsgTpCd8=3&txtPsgTpCd9=&txtDiscKndCd1=000&txtDiscKndCd2=000&txtDiscKndCd3=111&txtDiscKndCd4=&txtDiscKndCd5=131&txtDiscKndCd6=&txtDiscKndCd7=112&txtDiscKndCd8=321&txtDiscKndCd9=&txtCompaCnt1=0&txtCompaCnt2=0&txtCompaCnt3=0&txtCompaCnt4=0&txtCompaCnt5=0&txtCompaCnt6=0&txtCompaCnt7=0&txtCompaCnt8=0&txtCompaCnt9=&txtStndFlg=&txtJobId=&txtJrnyCnt=&txtDptStnConsOrdr1=&txtArvStnConsOrdr1=&txtDptStnRunOrdr1=&txtArvStnRunOrdr1=&txtDptStnConsOrdr2=&txtArvStnConsOrdr2=&txtDptStnRunOrdr2=&txtArvStnRunOrdr2=&txtPsrmClCd1=&txtJrnySqno1=&txtJrnyTpCd1=&txtDptDt1=&txtDptRsStnCd1=&txtDptRsStnCdNm1=&txtDptTm1=&txtArvRsStnCd1=&txtArvRsStnCdNm1=&txtArvTm1=&txtTrnNo1=&txtRunDt1=&txtTrnClsfCd1=&txtTrnGpCd1=&txtChgFlg1=&txtDoTrnFlg1=&txtPsrmClCd2=&txtJrnySqno2=&txtJrnyTpCd2=&txtDptDt2=&txtDptRsStnCd2=&txtDptRsStnCdNm2=&txtDptTm2=&txtArvRsStnCd2=&txtArvRsStnCdNm2=&txtArvTm2=&txtTrnNo2=&txtRunDt2=&txtTrnClsfCd2=&txtTrnGpCd2=&txtChgFlg2=&txtDoTrnFlg2=&selGoStartDay=&strHmac=&PageInx=&hidEasyTalk=&hidCapFlag="


const val MAX_COUNT = 3600

enum class KTXTicket(
    val targetName: String,
    val startTime: Int,
    val endTime: Int,
    val url: String,
    val isOnlyKtx: Boolean
) {
    SEOUL_TO_DONGDEAGU_14_HOUR_1("서울에서 동대구", 1350, 1618, DONGDAEGO_TO_SEOUL_14_FIRST, true),
    SEOUL_TO_DONGDEAGU_14_HOUR_2("서울에서 동대구", 1350, 1618, DONGDAEGO_TO_SEOUL_14_SECOND, true),
    SEOUL_TO_DONGDEAGU_14_HOUR_3("서울에서 동대구", 1350, 1618, DONGDAEGO_TO_SEOUL_14_THRID, true),
    SEOUL_TO_DONGDEAGU_18_HOUR_1("서울에서 동대구", 1800, 2000, DONGDAEGO_TO_SEOUL_18_FIRST, true),
    SEOUL_TO_DONGDEAGU_18_HOUR_2("서울에서 동대구", 1800, 2000, DONGDAEGO_TO_SEOUL_18_SECOND, true),
    SEOUL_TO_MASAN_15_HOUR("서울에서 마산", 1500, 1700, SEOUL_TO_MASAN_15, true),
}

val telegramBot = TelegramBot(TELEGRAM_BOT_TOKEN)
fun main() {

    val ktxAlarm = KTXAlarm()
    val ktxHttpRequest = OldHttpRequest()
    val startRequest = SendMessage(ADMIN_CHAT_ID, "서버 시작 v10.22")

    telegramBot.execute(startRequest)
    var count = 0
    while (count<1) {

        val threadList = KTXTicket.entries.map {
            Thread.startVirtualThread { ktxAlarm.sendKtxAlarm(it, ktxHttpRequest) }
        }
        threadList.forEach { it.join() }

        count++
        if (count > MAX_COUNT) {
            val serverHealthRequest = SendMessage(ADMIN_CHAT_ID, "서버 정상")
            telegramBot.execute(serverHealthRequest)
            count = 0
        }
    }
}

