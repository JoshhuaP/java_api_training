package fr.lernejo.navy_battle.Server;

import com.sun.net.httpserver.HttpExchange;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class PostHandlerFireTest {
    PostHandlerFire postHandlerFire;
    private String url;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws IOException {
        PostHandlerFire postHandlerFire = new PostHandlerFire(url);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        postHandlerFire = null;
        Assertions.assertNull(postHandlerFire);
    }
    @org.junit.jupiter.api.Test
    public void testHandle() throws IOException {
        int status = 202;
        String response = "Accepte";
        Assertions.assertNotNull(response);
        Assertions.assertEquals(202, status);
        Assertions.assertEquals("Accepte", response);
        Assertions.assertNotEquals(400, status);
        Assertions.assertNotEquals("400 - Bad Request", response);
        Assertions.assertNotEquals(404, status);
        Assertions.assertNotEquals("Not Found", response);
        Assertions.assertNotEquals(500, status);
        Assertions.assertNotEquals("Internal server error", response);
    }
}
