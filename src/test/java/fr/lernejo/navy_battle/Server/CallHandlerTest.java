package fr.lernejo.navy_battle.Server;

import com.sun.net.httpserver.HttpExchange;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class CallHandlerTest {
    CallHandler callHandler;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws IOException {
        callHandler = new CallHandler();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        callHandler = null;
    }

    @org.junit.jupiter.api.Test
    public void testHandle(HttpExchange t) throws IOException {
        InputStream is = t.getRequestBody();
        int status = 200;
        String response = "OK";
        byte[] byteArray =  response.getBytes(StandardCharsets.UTF_8);
        t.sendResponseHeaders(status, byteArray.length);
        Assertions.assertEquals(200, status);
        Assertions.assertEquals("OK", response);
        Assertions.assertEquals(byteArray, response.getBytes(StandardCharsets.UTF_8));
    }
}
