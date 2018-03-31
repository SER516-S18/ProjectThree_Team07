package network.server;

import network.model.Status;

import javax.websocket.DeploymentException;
import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static util.NetworkConstants.PORT;
import static util.NetworkConstants.HOST;
import static util.NetworkConstants.ROOT_PATH;

public class Server {

    private static org.glassfish.tyrus.server.Server server;

    public Server() {
        server = new org.glassfish.tyrus.server.Server(HOST, PORT, "/" + ROOT_PATH, ServerEndpoint.class);
    }

    public void start() {

        try {
            server.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Please press a key to stop the server.");
            reader.readLine();
        } catch (DeploymentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendStatus(Status status) {

        status.setRightWink(0.234);
        status.setBlink(0.123);
        status.setClench(0.2343);
        status.setLookingRight(0.2234);
        status.setEyebrowRaise(0.4444);
        status.setEyesOpen(0.343);
        status.setFrustration(0.4342);
        status.setLeftWink(0.23421);

        status.setLookingDown(0.23411);
        status.setLookingLeft(0.551);
        status.setLookingUp(0.234321);
        status.setSmile(0.1232);

        status.setExcitmentLongTerm(0.2343);
        status.setExcitementShortTerm(0.234);

        status.setMediation(0.34343);
        status.setEngagementBoredom(0.2343);

        for (Session peer : ServerEndpoint.peers) {
            try {
                peer.getBasicRemote().sendObject(status);
            } catch (IOException | EncodeException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new Server().start();

    }
}
