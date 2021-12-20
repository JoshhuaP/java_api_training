package fr.lernejo.navy_battle;

import fr.lernejo.navy_battle.Server.WebServer;
import org.junit.jupiter.api.Assertions;

public class LauncherTest {
    @org.junit.jupiter.api.Test
    public final void mainTest(String[] args) {
        final int port = Integer.parseInt(args[0]);
        final String url = args[1];
        WebServer server = new WebServer(port, url);
        Assertions.assertEquals(port, Integer.parseInt(args[0]));
        Assertions.assertNotEquals(url, args[1]);
    }
}
