package network.client;

import org.glassfish.tyrus.client.ClientManager;

import javax.websocket.DeploymentException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;

import static util.NetworkConstants.SERVER_URI;

public class Client {
    private static CountDownLatch latch;

    private static ClientManager clientManager;

    public Client() {
        clientManager = ClientManager.createClient();
    }

    public  void start() {
        latch = new CountDownLatch(1);

        try {
            clientManager.connectToServer(ClientEndpoint.class, new URI(SERVER_URI));
            latch.await();

        } catch (DeploymentException | URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
       new  Client().start();
    }
}



