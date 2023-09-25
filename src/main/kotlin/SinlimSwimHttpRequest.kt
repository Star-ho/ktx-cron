import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class SinlimSwimHttpRequest {
    fun sendRequest(url: String, objectMapper: ObjectMapper): Array<SinlimSwimResponse> {
        val client: HttpClient = HttpClient.newHttpClient()

        val request: HttpRequest = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
            .setHeader("Content-Type","application/x-www-form-urlencoded")
            .setHeader("Accept-Encoding","gzip, deflate, br")
            .build()
        val bodyString = client.send(request, HttpResponse.BodyHandlers.ofString()).body()
        println(bodyString)

        return objectMapper.readValue(bodyString, Array<SinlimSwimResponse>::class.java)
    }
}

class SinlimSwimParam(
    val company_code: String = "KWAN_AK02",
    val search_type: String = "R",
    val category_cd: String = "1000010000",
    val category_level: String = "2",
    val page: Int = 1,
    val page_size: Int = 100,
)
class SinlimSwimResponse(
    val comcd: String,
    val comnm: String,
    val class_cd: String,
    val class_nm: String,
    val train_stime: String,
    val train_etime: String,
    val course_fee: String?,
    val receive_etime: String?,
    val status: String,
    val receive_kind: String?,
    val target_age_name: String?,
    val sports_cd: String,
    val train_day_nm: String,
    val capa: String,
    val reg_person: String,
    val teacher_no: String?,
    val teacher_name: String,
    val total_count: Int,
    val category1: String,
    val category2: String
)