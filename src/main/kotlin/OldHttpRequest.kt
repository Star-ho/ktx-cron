import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class OldHttpRequest:CustomHttpRequest{
    override suspend fun sendRequest(ktxUrl: String, body: String): String {
        val client: HttpClient = HttpClient.newHttpClient()

        val request: HttpRequest = HttpRequest.newBuilder()
            .uri(URI.create(ktxUrl))
            .POST(HttpRequest.BodyPublishers.ofString(body))
            .build()

        return client.send(request, HttpResponse.BodyHandlers.ofString()).body()
    }
}