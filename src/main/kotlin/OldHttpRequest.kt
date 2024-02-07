import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class OldHttpRequest:CustomHttpRequest{
    override fun sendRequest(ktxUrl: String, body: String): String {
        val client: HttpClient = HttpClient.newHttpClient()

        val request: HttpRequest = HttpRequest.newBuilder()
            .uri(URI.create(ktxUrl))
            .POST(HttpRequest.BodyPublishers.ofString(body))
            .setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",)
            .setHeader("Content-Type","application/x-www-form-urlencoded")
            .build()

        val res = client.send(request, HttpResponse.BodyHandlers.ofString()).body()
        client.close()
        return res
    }
}