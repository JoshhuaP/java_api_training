package fr.lernejo.navy_battle;

import fr.lernejo.navy_battle.Server.WebServer;
import org.junit.jupiter.api.Assertions;

public class LauncherTest {
    @org.junit.jupiter.api.Test
    public final void mainTest() {
        final int port = 9876;
        final String url = "http://localhost:9876/api/game/start/";
        WebServer server = new WebServer(port, url);
        Assertions.assertEquals(port, 9876);
        Assertions.assertEquals(url, "http://localhost:9876/api/game/start/");
    }
}
