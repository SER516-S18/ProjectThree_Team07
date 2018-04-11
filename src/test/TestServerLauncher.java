package test;

import controller.client.ServerLauncher;
import network.model.Connection;
import org.junit.Test;
import util.NetworkConstants;
import view.server.Server;

import static junit.framework.TestCase.assertEquals;

public class TestServerLauncher {

    @Test
    public void testServerLauncherFactory() {
        ServerLauncher.serverLauncherFactory();

        assertEquals(Server.isServerUp,true);
        assertEquals(Connection.getInstance().getHost(), NetworkConstants.HOST);
        assertEquals(Connection.getInstance().getPort(), NetworkConstants.PORT);
    }
}