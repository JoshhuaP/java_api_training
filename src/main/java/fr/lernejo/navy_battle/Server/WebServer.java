package fr.lernejo.navy_battle.Server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class WebServer {
    final int port;
    public WebServer(int port) {
        this.port = port;
    }
    public final void createServer() {
        try {
            InetSocketAddress addr = new InetSocketAddress(port);
            HttpServer server = HttpServer.create(addr, 0);
            server.setExecutor(Executors.newFixedThreadPool(1));
            server.createContext("/ping", new CallHandler());
            server.createContext("/api/game/start", new PostHandler());
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
