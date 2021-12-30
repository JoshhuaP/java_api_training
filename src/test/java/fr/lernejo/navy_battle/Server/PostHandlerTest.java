package fr.lernejo.navy_battle.Server;

import com.sun.net.httpserver.HttpExchange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

public class PostHandlerTest {
    PostHandler postHandler;
    private int port;
    private String url;
    private HttpExchange httpExchange;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws IOException {
        postHandler = new PostHandler(port, url);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        postHandler = null;
        Assertions.assertNull(postHandler);
        Assertions.assertNull(httpExchange);
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

    @Test
    public void handle_nullPointer_test() {
        NullPointerException thrown = assertThrows(
            NullPointerException.class,
            () -> postHandler.handle(httpExchange),
            "Expected doThing() to throw, but it didn't"
        );
    }

    @Test
    public void ArrayResponse_nullPointer_test() {
        NullPointerException thrown = assertThrows(
            NullPointerException.class,
            () -> postHandler.ArrayResponse(httpExchange),
            "Expected doThing() to throw, but it didn't"
        );
    }
}
