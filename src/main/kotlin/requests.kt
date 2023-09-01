import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.util.*


class KtxHttpRequest {
    @OptIn(InternalAPI::class)
    suspend fun sendRequest(ktxUrl: String, aa: String): String {
        return HttpClient(CIO).post(ktxUrl) {
            headers {
                set(
                    "Accept",
                    "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"
                )
                set("Content-Type", "application/x-www-form-urlencoded")
            }
            setBody(aa)
        }.body()
    }
}