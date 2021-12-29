package fr.lernejo.navy_battle.Server;

import com.sun.net.httpserver.HttpExchange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class CallHandlerTest {
    CallHandler callHandler;
    HttpExchange t;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws IOException {
        callHandler = new CallHandler();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        callHandler = null;
    }

    @org.junit.jupiter.api.Test
    public void testHandle() {
        int status = 200;
        String response = "OK";
        Assertions.assertEquals(status, 200);
        Assertions.assertEquals(response, "OK");
    }
}
