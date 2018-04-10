package test;

import network.client.Client;
import network.model.Connection;
import network.server.Server;
import org.junit.Before;
import org.junit.Test;
import util.NetworkConstants;

import static org.junit.Assert.assertEquals;

public class TestNetwork {

    private Server server;
    private Client client;

    @Before
    public void setUp() {
        server = Server.getInstance();
        client = Client.getInstance();

        server.start(NetworkConstants.HOST, NetworkConstants.PORT);
    }

    @Test
    public void testConnectionModel() {
        assertEquals(NetworkConstants.HOST, Connection.getInstance().getHost());
        assertEquals(NetworkConstants.PORT, Connection.getInstance().getPort());
    }

    @Test
    public void testClientConnection() {
        client.start();

        assertEquals(server.numConnections(), 1);
    }
}
