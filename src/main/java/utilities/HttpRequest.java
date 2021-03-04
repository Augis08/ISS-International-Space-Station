package utilities;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class HttpRequest {
    StringBuilder stringBuilder;

    public HttpRequest(String url) {
        this.stringBuilder = new StringBuilder();
        HttpClient client = HttpClient.newHttpClient();
        java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(stringBuilder::append)
                .join();
    }

    public String toString() {
        return stringBuilder.toString();
    }
}
