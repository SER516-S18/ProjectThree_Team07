package network.client;

import network.model.Connection;
import org.glassfish.tyrus.client.ClientManager;

import javax.websocket.DeploymentException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Websocket singleton client implementation
 *
 * @author team 7
 */
public class Client {

  private static ClientManager clientManager;

  private static Client clientInstance;

  private Client() {}

  /**
   * Singleton implementation
   *
   * @return Client instance
   */
  public static Client getInstance() {
    if (clientInstance == null) {
      clientManager = ClientManager.createClient();
      clientInstance = new Client();
    }
    return clientInstance;
  }

  /** Starts the client */
  public void start() {
    try {
      clientManager.connectToServer(
          ClientEndpoint.class,
          new URI(
              "ws://"
                  + Connection.getInstance().getHost()
                  + ":"
                  + Connection.getInstance().getPort()
                  + "/ws/status"));
    } catch (DeploymentException | URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }
}
