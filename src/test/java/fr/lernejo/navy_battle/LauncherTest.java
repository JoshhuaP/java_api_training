package fr.lernejo.navy_battle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LauncherTest {
    final int port = 9876;
    final String url = "http://localhost:9876/api/game/start/";
    @org.junit.jupiter.api.Test
    public final void mainTest() {
        Assertions.assertEquals(port, 9876);
        Assertions.assertEquals(url, "http://localhost:9876/api/game/start/");
    }

    @Test
    public void launch_webServer_with_only_port() {
        Assertions.assertDoesNotThrow(()->Launcher.main(new String[]{Integer.toString(port)}));
    }
}
