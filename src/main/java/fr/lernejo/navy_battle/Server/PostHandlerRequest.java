package fr.lernejo.navy_battle.Server;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class PostHandlerRequest {
    final String url;
    final int port;
    public PostHandlerRequest(int port, String url) {this.port = port; this.url = url;}
    public final void SendRequest() throws IOException {
        final HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url+ "/api/game/start"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("{\"id\": \"1\",\"message\": \"leMessage\", \"url\": \"http://localhost:"+port+"\"}"))
            .build();
        final HttpClient client = HttpClient.newHttpClient();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).join();
    }
}
