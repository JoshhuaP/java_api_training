package fr.lernejo.navy_battle;

import fr.lernejo.navy_battle.Server.WebServer;

public class Launcher {
    public static void main(String[] args) {
        final int port = Integer.parseInt(args[0]);
        WebServer server = new WebServer(port);
        server.createServer();
    }
}
