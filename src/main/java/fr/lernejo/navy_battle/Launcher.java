package fr.lernejo.navy_battle;

import fr.lernejo.navy_battle.Server.PostHandlerRequest;
import fr.lernejo.navy_battle.Server.WebServer;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
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
            final PostHandlerRequest postHandlerRequest = new PostHandlerRequest(port, url);
            postHandlerRequest.SendRequest();
        } else {System.out.println("Il faut ajouter au moins un paramètre et pas plus de deux");}
    }
}
