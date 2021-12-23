package fr.lernejo.navy_battle.Server;

import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class WebServerTest {
    WebServer webServer;
    @org.junit.jupiter.api.Test
    final void ServerTest() {
        int port = 9876;
        String url = "http://localhost:9876/api/game/start/";
        Assertions.assertEquals(port, 9876);
        Assertions.assertEquals(url, "http://localhost:9876/api/game/start/");
    }

    @org.junit.jupiter.api.Test
    final void createServerTest() throws IOException {
        InetSocketAddress addr = new InetSocketAddress(9876);
        HttpServer server = HttpServer.create(addr, 0);
        Executor executors = Executors.newFixedThreadPool(1);
        server.setExecutor(executors);
        server.start();
        Assertions.assertEquals(server.getExecutor(), executors);
        org.assertj.core.api.Assertions.assertThatNoException().isThrownBy(server::start);
    }
}
