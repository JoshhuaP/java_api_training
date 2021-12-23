package fr.lernejo.navy_battle;

import fr.lernejo.navy_battle.Server.WebServer;

public class Launcher {
    public static void main(String[] args) {
        final int port = Integer.parseInt(args[0]);
        final int nbParam = args.length;
        if (nbParam == 1) {
            WebServer server = new WebServer(port);
            server.createServer();
        }
        else if (nbParam == 2){
            final String url = args[1];
            WebServer server = new WebServer(port, url);
            server.createServer();
        }
        else {
            System.out.println("Il faut ajouter au moins un paramètre et pas plus de deux");
        }
    }
}
