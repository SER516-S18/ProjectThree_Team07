package test;

import network.model.Connection;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConnectionTest {

    @Test
    public void testConnectionModel() {
        Connection connection = Connection.getInstance();
        connection.setHost("Localhost");
        connection.setPort(8080);
        assertEquals(connection.getHost(), "Localhost");
        assertEquals(connection.getPort(), 8080);
    }

}