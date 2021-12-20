package fr.lernejo.navy_battle.Server;

import com.sun.net.httpserver.HttpExchange;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class PostHandlerTest {
    PostHandler postHandler;
    private String url;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws IOException {
        postHandler = new PostHandler(url);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        postHandler = null;
    }

    @org.junit.jupiter.api.Test
    public void testHandle(HttpExchange t) throws IOException {
        int status = 0;
        String response = "";
        Assertions.assertEquals(status, 202);
        Assertions.assertEquals(response, "Accepte");
        Assertions.assertNotEquals(status, 400);
        Assertions.assertNotEquals(response, "400 - Bad Request");
        Assertions.assertNotEquals(status, 404);
        Assertions.assertNotEquals(response, "Not Found");
        Assertions.assertNotEquals(status, 500);
        Assertions.assertNotEquals(response, "Internal server error");
        Assertions.assertThrows(IllegalArgumentException.class, ()->postHandler.handle(t));
    }
}
