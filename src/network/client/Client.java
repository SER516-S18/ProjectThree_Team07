package network.client;

import org.glassfish.tyrus.client.ClientManager;

import javax.websocket.DeploymentException;
import java.net.URI;
import java.net.URISyntaxException;

import static util.NetworkConstants.SERVER_URI;

public class Client {

    private ClientManager clientManager;

    public Client() {
        clientManager = ClientManager.createClient();
    }

    public void start() {
        try {
            clientManager.connectToServer(ClientEndpoint.class, new URI(SERVER_URI));
        } catch (DeploymentException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
