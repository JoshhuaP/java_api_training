package fr.lernejo.navy_battle.Server;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import fr.lernejo.navy_battle.Json.JsonParser;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
public class PostHandlerFire implements HttpHandler {
    final String url;
    public PostHandlerFire(String url) {
        this.url = url;
    }

    public final void handle(HttpExchange t) throws IOException {
        int status = 0;
        String response = "";
        try {
            if (url != null) {
                HttpClient newClient = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:9876/api/game/fire"))
                    .POST(HttpRequest.BodyPublishers.ofString("Fire"))
                    .build();
            }
            if (t.getRequestMethod().equals("GET")) {
                InputStream is = t.getRequestBody();
                JsonParser Parser = new JsonParser();
                JSONObject jsonObject = Parser.Parser(is);
                if (jsonObject != null) {
                    status = 202;
                    response = "Accepte";
                } else {
                    status = 400;
                    response = "400 - Bad request";
                }
            }
            else {
                status = 404;
                response = "Not Found";
            }
        }
        catch (Exception e) {
            status = 500;
            response = "internal server error";
            e.printStackTrace();
        }
        byte[] byteArray =  response.getBytes(StandardCharsets.UTF_8);
        t.sendResponseHeaders(status, byteArray.length);
        OutputStream os = t.getResponseBody();
        os.write(byteArray);
        os.close();
    }
}
