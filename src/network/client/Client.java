package network.client;

import org.glassfish.tyrus.client.ClientManager;

import javax.websocket.DeploymentException;
import java.net.URI;
import java.net.URISyntaxException;

import static util.NetworkConstants.SERVER_URI;

public class Client {

    private static ClientManager clientManager;

    private static Client clientInstance;

    private Client() {}

    public static Client getInstance() {
        if(clientInstance == null) {
            clientManager = ClientManager.createClient();
            clientInstance = new Client();
        }
        return clientInstance;
    }

    public void start() {
        try {
            clientManager.connectToServer(ClientEndpoint.class, new URI(SERVER_URI));
        } catch (DeploymentException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Client client = Client.getInstance();

        client.start();

        for(;;){}
    }
}



