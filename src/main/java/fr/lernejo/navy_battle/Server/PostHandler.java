package fr.lernejo.navy_battle.Server;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import fr.lernejo.navy_battle.Json.JsonParser;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
public class PostHandler implements HttpHandler {
    final String url;
    final int port;
    public PostHandler(int port, String url) {this.port = port; this.url = url;}
    public final void HttpClient() {
        HttpClient newClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:9876/api/game/start"))
            .POST(HttpRequest.BodyPublishers.ofString("{\"id\": \"1\",\"message\": \"leMessage\", \"url\": \"http://localhost:"+port+"\"}"))
            .build();
    }
    public final String[] ArrayResponse(HttpExchange t) throws IOException {
        int status;
        String response;
        String[] arr = new String[2];
        if (url != null) {this.HttpClient();}
        if (t.getRequestMethod().equals("POST")) {
            JSONObject jsonObject = new JsonParser().Parser(t.getRequestBody());
            if (jsonObject != null) {status = 202;response = "{\"id\": \"1\",\"message\": \"leMessage\", \"url\": \"http://localhost:"+port+"\"}";}
            else { status = 400; response = "false";}
        }
        else { status = 404; response = "Not Found";}
        arr[0] = String.valueOf(status);
        arr[1] = response;
        return arr;
    }
    public final void handle(HttpExchange t) throws IOException {
        int status;
        String response;
        try {
            String[] arr = this.ArrayResponse(t);
            status = Integer.parseInt(arr[0]);
            response = arr[1];
        }
        catch (Exception e) {status = 500; response = "internal server error"; e.printStackTrace();}
        t.sendResponseHeaders(status, response.getBytes(StandardCharsets.UTF_8).length);
        try (OutputStream os = t.getResponseBody()) {os.write(response.getBytes(StandardCharsets.UTF_8));}
    }
}
