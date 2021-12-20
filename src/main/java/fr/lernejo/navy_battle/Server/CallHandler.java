package fr.lernejo.navy_battle.Server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class CallHandler implements HttpHandler {
    public final void handle(HttpExchange t) throws IOException {
        InputStream is = t.getRequestBody();
        int status = 200;
        String response = "OK";
        byte[] byteArray =  response.getBytes(StandardCharsets.UTF_8);
        t.sendResponseHeaders(status, byteArray.length);
        OutputStream os = t.getResponseBody();
        os.write(byteArray);
        os.close();
    }
}
