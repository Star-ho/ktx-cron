import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.request.SendMessage

const val TELEGRAM_BOT_TOKEN = "5930610065:AAGn-Rls4_wxzO1cU6cOmD3oR0gaohX6ay4"

const val MEGABOX_CLIENT_CHAT_ID = "-1001820329036"
const val KTX_CLIENT_CHAT_ID = "-947068919"

const val ADMIN_CHAT_ID = "1052011050"
const val KTX_URL = "https://www.letskorail.com/ebizprd/EbizPrdTicketPr21111_i1.do"
//const val CHUNG_RYANG_RI_TO_ANDONG_URL =
//    "txtGoStartCode=0090&txtGoEndCode=0526&radJobId=1&selGoTrain=05&txtSeatAttCd_4=015&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtPsgFlg_2=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&chkCpn=N&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=1&txtPsgCnt2=0&txtGoPage=1&txtGoAbrdDt=20230928&selGoRoom=&useSeatFlg=&useServiceFlg=&checkStnNm=Y&txtMenuId=11&SeandYo=&txtGoStartCode2=&txtGoEndCode2=&hidEasyTalk=&txtGoStart=%EC%B2%AD%EB%9F%89%EB%A6%AC&txtGoEnd=%EC%95%88%EB%8F%99&start=2023.9.28&selGoHour=00&txtGoHour=000000&selGoYear=2023&selGoMonth=09&selGoDay=28&txtGoYoil=%EB%AA%A9&txtPsgFlg_1=1"
//
//const val SINLIM_ATHLETIC_CENTER_LECTURE_URL =
//    "https://www.gwanakgongdan.or.kr/rest/lecture/list?company_code=KWAN_AK02&search_type=R&category_cd=1000010000&category_level=2&page=1&page_size=100"

//const val YONGSAN_TO_SUNCHEN_URL =
//    "hidNormalRsv=&hidBiztransferRsv=&srTOrder=&hidDiscount=&selGoTrain=05&txtPsgFlg_1=2&txtPsgFlg_2=0&txtPsgFlg_8=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtSeatAttCd_4=015&selGoTrainRa=05&radJobId=1&txtGoStart=%EC%9A%A9%EC%82%B0&txtGoEnd=%EC%88%9C%EC%B2%9C&txtGoStartCode=&txtGoEndCode=&selGoYear=2023&selGoMonth=10&selGoDay=21&selGoHour=07&txtGoHour=070000&txtGoYoil=%ED%86%A0&ret_url=&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=2&txtPsgCnt2=0&txtGoPage=1&txtGoAbrdDt=20231021&selGoRoom=&useSeatFlg=&useServiceFlg=&checkStnNm=Y&SeandYo=N&txtGoStartCode2=&txtGoEndCode2=&txtPnrNo=&hidStlFlg=&chkTrnSeq=&chkChgTrn1=&chkChgTrn2=&chkBtnImgTrn1=&chkBtnImgTrn2=&chkInitFlg=Y&txtMenuId=11&ra=1&txtSeatAttCd1=&txtSeatAttCd2=&txtSeatAttCd3=&txtSeatAttCd4=&txtSeatAttCd4_1=&txtSeatAttCd5=&strChkCpn=N&txtTotPsgCnt=&txtSrcarCnt=0&txtSrcarCnt1=0&txtSrcarNo1=&txtSrcarNo2=&txtSrcarNo3=&txtSrcarNo4=&txtSrcarNo5=&txtSrcarNo6=&txtSrcarNo7=&txtSrcarNo8=&txtSrcarNo9=&txtSeatNo1=&txtSeatNo2=&txtSeatNo3=&txtSeatNo4=&txtSeatNo5=&txtSeatNo6=&txtSeatNo7=&txtSeatNo8=&txtSeatNo9=&txtSrcarNo1_1=&txtSrcarNo1_2=&txtSrcarNo1_3=&txtSrcarNo1_4=&txtSrcarNo1_5=&txtSrcarNo1_6=&txtSrcarNo1_7=&txtSrcarNo1_8=&txtSrcarNo1_9=&txtSeatNo1_1=&txtSeatNo1_2=&txtSeatNo1_3=&txtSeatNo1_4=&txtSeatNo1_5=&txtSeatNo1_6=&txtSeatNo1_7=&txtSeatNo1_8=&txtSeatNo1_9=&txtDmdSeatAtt1=&txtDmdSeatAtt2=&txtDmdSeatAtt3=&txtDmdSeatAtt4=&txtDmdSeatAtt5=&txtDmdSeatAtt6=&txtDmdSeatAtt7=&txtDmdSeatAtt8=&txtDmdSeatAtt9=&txtDmdSeatAtt1_1=&txtDmdSeatAtt1_2=&txtDmdSeatAtt1_3=&txtDmdSeatAtt1_4=&txtDmdSeatAtt1_5=&txtDmdSeatAtt1_6=&txtDmdSeatAtt1_7=&txtDmdSeatAtt1_8=&txtDmdSeatAtt1_9=&hidRsvChgNo=&hidRsvTpCd=03&txtPsgTpCd1=1&txtPsgTpCd2=3&txtPsgTpCd3=1&txtPsgTpCd4=&txtPsgTpCd5=1&txtPsgTpCd6=&txtPsgTpCd7=1&txtPsgTpCd8=3&txtPsgTpCd9=&txtDiscKndCd1=000&txtDiscKndCd2=000&txtDiscKndCd3=111&txtDiscKndCd4=&txtDiscKndCd5=131&txtDiscKndCd6=&txtDiscKndCd7=112&txtDiscKndCd8=321&txtDiscKndCd9=&txtCompaCnt1=0&txtCompaCnt2=0&txtCompaCnt3=0&txtCompaCnt4=0&txtCompaCnt5=0&txtCompaCnt6=0&txtCompaCnt7=0&txtCompaCnt8=0&txtCompaCnt9=&txtStndFlg=&txtJobId=&txtJrnyCnt=&txtDptStnConsOrdr1=&txtArvStnConsOrdr1=&txtDptStnRunOrdr1=&txtArvStnRunOrdr1=&txtDptStnConsOrdr2=&txtArvStnConsOrdr2=&txtDptStnRunOrdr2=&txtArvStnRunOrdr2=&txtPsrmClCd1=&txtJrnySqno1=&txtJrnyTpCd1=&txtDptDt1=&txtDptRsStnCd1=&txtDptRsStnCdNm1=&txtDptTm1=&txtArvRsStnCd1=&txtArvRsStnCdNm1=&txtArvTm1=&txtTrnNo1=&txtRunDt1=&txtTrnClsfCd1=&txtTrnGpCd1=&txtChgFlg1=&txtDoTrnFlg1=&txtPsrmClCd2=&txtJrnySqno2=&txtJrnyTpCd2=&txtDptDt2=&txtDptRsStnCd2=&txtDptRsStnCdNm2=&txtDptTm2=&txtArvRsStnCd2=&txtArvRsStnCdNm2=&txtArvTm2=&txtTrnNo2=&txtRunDt2=&txtTrnClsfCd2=&txtTrnGpCd2=&txtChgFlg2=&txtDoTrnFlg2=&selGoStartDay=&strHmac=&PageInx=&hidEasyTalk=&hidCapFlag=\n"
//const val SEOUL_TO_SUNCHEN_URL =
//    "hidNormalRsv=&hidBiztransferRsv=&srTOrder=&hidDiscount=&selGoTrain=05&txtPsgFlg_1=2&txtPsgFlg_2=0&txtPsgFlg_8=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtSeatAttCd_4=015&selGoTrainRa=05&radJobId=1&txtGoStart=%EC%84%9C%EC%9A%B8&txtGoEnd=%EC%88%9C%EC%B2%9C&txtGoStartCode=&txtGoEndCode=&selGoYear=2023&selGoMonth=10&selGoDay=21&selGoHour=00&txtGoHour=000000&txtGoYoil=%ED%86%A0&ret_url=&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=2&txtPsgCnt2=0&txtGoPage=1&txtGoAbrdDt=20231021&selGoRoom=&useSeatFlg=&useServiceFlg=&checkStnNm=Y&SeandYo=N&txtGoStartCode2=&txtGoEndCode2=&txtPnrNo=&hidStlFlg=&chkTrnSeq=&chkChgTrn1=&chkChgTrn2=&chkBtnImgTrn1=&chkBtnImgTrn2=&chkInitFlg=Y&txtMenuId=11&ra=1&txtSeatAttCd1=&txtSeatAttCd2=&txtSeatAttCd3=&txtSeatAttCd4=&txtSeatAttCd4_1=&txtSeatAttCd5=&strChkCpn=N&txtTotPsgCnt=&txtSrcarCnt=0&txtSrcarCnt1=0&txtSrcarNo1=&txtSrcarNo2=&txtSrcarNo3=&txtSrcarNo4=&txtSrcarNo5=&txtSrcarNo6=&txtSrcarNo7=&txtSrcarNo8=&txtSrcarNo9=&txtSeatNo1=&txtSeatNo2=&txtSeatNo3=&txtSeatNo4=&txtSeatNo5=&txtSeatNo6=&txtSeatNo7=&txtSeatNo8=&txtSeatNo9=&txtSrcarNo1_1=&txtSrcarNo1_2=&txtSrcarNo1_3=&txtSrcarNo1_4=&txtSrcarNo1_5=&txtSrcarNo1_6=&txtSrcarNo1_7=&txtSrcarNo1_8=&txtSrcarNo1_9=&txtSeatNo1_1=&txtSeatNo1_2=&txtSeatNo1_3=&txtSeatNo1_4=&txtSeatNo1_5=&txtSeatNo1_6=&txtSeatNo1_7=&txtSeatNo1_8=&txtSeatNo1_9=&txtDmdSeatAtt1=&txtDmdSeatAtt2=&txtDmdSeatAtt3=&txtDmdSeatAtt4=&txtDmdSeatAtt5=&txtDmdSeatAtt6=&txtDmdSeatAtt7=&txtDmdSeatAtt8=&txtDmdSeatAtt9=&txtDmdSeatAtt1_1=&txtDmdSeatAtt1_2=&txtDmdSeatAtt1_3=&txtDmdSeatAtt1_4=&txtDmdSeatAtt1_5=&txtDmdSeatAtt1_6=&txtDmdSeatAtt1_7=&txtDmdSeatAtt1_8=&txtDmdSeatAtt1_9=&hidRsvChgNo=&hidRsvTpCd=03&txtPsgTpCd1=1&txtPsgTpCd2=3&txtPsgTpCd3=1&txtPsgTpCd4=&txtPsgTpCd5=1&txtPsgTpCd6=&txtPsgTpCd7=1&txtPsgTpCd8=3&txtPsgTpCd9=&txtDiscKndCd1=000&txtDiscKndCd2=000&txtDiscKndCd3=111&txtDiscKndCd4=&txtDiscKndCd5=131&txtDiscKndCd6=&txtDiscKndCd7=112&txtDiscKndCd8=321&txtDiscKndCd9=&txtCompaCnt1=0&txtCompaCnt2=0&txtCompaCnt3=0&txtCompaCnt4=0&txtCompaCnt5=0&txtCompaCnt6=0&txtCompaCnt7=0&txtCompaCnt8=0&txtCompaCnt9=&txtStndFlg=&txtJobId=&txtJrnyCnt=&txtDptStnConsOrdr1=&txtArvStnConsOrdr1=&txtDptStnRunOrdr1=&txtArvStnRunOrdr1=&txtDptStnConsOrdr2=&txtArvStnConsOrdr2=&txtDptStnRunOrdr2=&txtArvStnRunOrdr2=&txtPsrmClCd1=&txtJrnySqno1=&txtJrnyTpCd1=&txtDptDt1=&txtDptRsStnCd1=&txtDptRsStnCdNm1=&txtDptTm1=&txtArvRsStnCd1=&txtArvRsStnCdNm1=&txtArvTm1=&txtTrnNo1=&txtRunDt1=&txtTrnClsfCd1=&txtTrnGpCd1=&txtChgFlg1=&txtDoTrnFlg1=&txtPsrmClCd2=&txtJrnySqno2=&txtJrnyTpCd2=&txtDptDt2=&txtDptRsStnCd2=&txtDptRsStnCdNm2=&txtDptTm2=&txtArvRsStnCd2=&txtArvRsStnCdNm2=&txtArvTm2=&txtTrnNo2=&txtRunDt2=&txtTrnClsfCd2=&txtTrnGpCd2=&txtChgFlg2=&txtDoTrnFlg2=&selGoStartDay=&strHmac=&PageInx=&hidEasyTalk=&hidCapFlag=\n"

const val DONGDAEGO_TO_SEOUL_FIRST =
    "txtGoStartCode=0015&txtGoEndCode=0001&radJobId=1&selGoTrain=05&txtSeatAttCd_4=015&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtPsgFlg_2=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&chkCpn=N&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=1&txtPsgCnt2=0&txtGoPage=1&txtGoAbrdDt=20231117&selGoRoom=&useSeatFlg=&useServiceFlg=&checkStnNm=Y&txtMenuId=11&SeandYo=N&txtGoStartCode2=&txtGoEndCode2=&hidEasyTalk=&txtGoStart=%EB%8F%99%EB%8C%80%EA%B5%AC&txtGoEnd=%EC%84%9C%EC%9A%B8&start=2023.11.17&selGoHour=14&txtGoHour=140000&selGoYear=2023&selGoMonth=11&selGoDay=17&txtGoYoil=%EA%B8%88&txtPsgFlg_1=1"

const val DONGDAEGO_TO_SEOUL_SECOND =
"&txtGoAbrdDt=20231117&txtGoHour=150700&selGoYear=2023&selGoMonth=11&selGoDay=17&selGoHour=14&txtGoPage=2&txtGoStartCode=0015&txtGoStart=%EB%8F%99%EB%8C%80%EA%B5%AC&txtGoEndCode=0001&txtGoEnd=%EC%84%9C%EC%9A%B8&selGoTrain=05&selGoRoom=&selGoRoom1=&txtGoTrnNo=&useSeatFlg=&useServiceFlg=&selGoSeat=&selGoService=&txtPnrNo=&hidRsvChgNo=&hidStlFlg=&radJobId=1&SeandYo=&hidRsvTpCd=03&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=1&txtPsgCnt2=0&txtMenuId=11&txtPsgFlg_1=1&txtPsgFlg_2=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&txtPsgFlg_8=&chkCpn=N&txtSeatAttCd_4=015&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtGoStartCode2=&txtGoEndCode2=&hidDiscount=&hidEasyTalk=&adjcCheckYn=N"

const val DONGDAEGO_TO_SEOUL_THIRD =
"&txtGoAbrdDt=20231117&txtGoHour=163300&selGoYear=2023&selGoMonth=11&selGoDay=17&selGoHour=14&txtGoPage=2&txtGoStartCode=0015&txtGoStart=%EB%8F%99%EB%8C%80%EA%B5%AC&txtGoEndCode=0001&txtGoEnd=%EC%84%9C%EC%9A%B8&selGoTrain=05&selGoRoom=&selGoRoom1=&txtGoTrnNo=&useSeatFlg=&useServiceFlg=&selGoSeat=&selGoService=&txtPnrNo=&hidRsvChgNo=&hidStlFlg=&radJobId=1&SeandYo=&hidRsvTpCd=03&selGoSeat1=015&selGoSeat2=&txtPsgCnt1=1&txtPsgCnt2=0&txtMenuId=11&txtPsgFlg_1=1&txtPsgFlg_2=0&txtPsgFlg_3=0&txtPsgFlg_4=0&txtPsgFlg_5=0&txtPsgFlg_8=&chkCpn=N&txtSeatAttCd_4=015&txtSeatAttCd_3=000&txtSeatAttCd_2=000&txtGoStartCode2=&txtGoEndCode2=&hidDiscount=&hidEasyTalk=&adjcCheckYn=N"
enum class KTXTicket(
    val targetName: String,
    val startTime: Int,
    val endTime: Int,
    val url: String,
    val isOnlyKtx: Boolean
) {
    DONGDEAGU_TO_SEOUL_FIRST("동대구에서 서울", 1400, 1500, DONGDAEGO_TO_SEOUL_FIRST, true),
    DONGDEAGU_TO_SEOUL_SECOND("동대구에서 서울", 1400, 1500, DONGDAEGO_TO_SEOUL_SECOND, true),
    DONGDEAGU_TO_SEOUL_THIRD("동대구에서 서울", 1400, 1500, DONGDAEGO_TO_SEOUL_THIRD, true),

//    SEOUL_TO_SUNCHEN("서울에서 순천", 700, 1000, SEOUL_TO_SUNCHEN_URL, false),
}

val telegramBot = TelegramBot(TELEGRAM_BOT_TOKEN)
fun main() {
    val ktxAlarm = KTXAlarm()
    val ktxHttpRequest = OldHttpRequest()
    val startRequest = SendMessage(ADMIN_CHAT_ID, "서버 시작 v10.2")

    telegramBot.execute(startRequest)
    var count = 0
    while (true) {
        ktxAlarm.sendKtxAlarm(KTXTicket.DONGDEAGU_TO_SEOUL_FIRST, ktxHttpRequest)
        ktxAlarm.sendKtxAlarm(KTXTicket.DONGDEAGU_TO_SEOUL_SECOND, ktxHttpRequest)
        ktxAlarm.sendKtxAlarm(KTXTicket.DONGDEAGU_TO_SEOUL_THIRD, ktxHttpRequest)

        count++
        val loop = 3600
        if (count > loop) {
            val serverHealthRequest = SendMessage(ADMIN_CHAT_ID, "서버 정상")
            telegramBot.execute(serverHealthRequest)
            count = 0
        }
    }
}

