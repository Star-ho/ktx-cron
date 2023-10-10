class SwimgAlarm {


//fun sendSwimAlarm(objectMapper: ObjectMapper) {
//    val response = SinlimSwimHttpRequest().sendRequest(SINLIM_ATHLETIC_CENTER_LECTURE_URL, objectMapper)
//    val remainLectureList = response
//        .filter { it.capa.toInt() - it.reg_person.toInt() > 0 }
//        .filter { (it.class_cd == "00038" || it.class_cd == "00046") }
//
//    remainLectureList.forEach {
//        val request = SendMessage(MEGABOX_CLIENT_CHAT_ID, "${it.comnm} ${it.train_day_nm}  ${it.train_stime}")
//        telegramBot.execute(request)
//    }
//}
}