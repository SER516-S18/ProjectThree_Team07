package network.server;

import network.model.Connection;
import network.model.Status;
import view.server.components.Console;

import javax.websocket.DeploymentException;
import javax.websocket.EncodeException;
import javax.websocket.Session;

import java.io.IOException;

import static util.NetworkConstants.ROOT_PATH;

/**
 * Websocket singleton server implementation
 *
 * @author team 7
 */
public class Server {

  private static org.glassfish.tyrus.server.Server server;

  private static Server serverInstance;

  private Server() {}

  public static Server getInstance() {
    if (serverInstance == null) {
      serverInstance = new Server();
    }
    return serverInstance;
  }

  /**
   * Starts server under the given host and port
   *
   * @param host ip address of the server
   * @param port server port
   */
  public void start(String host, int port) {
    try {
      server =
          new org.glassfish.tyrus.server.Server(host, port, "/" + ROOT_PATH, ServerEndpoint.class);
      server.start();
    } catch (DeploymentException e) {
      e.printStackTrace();
    } catch (Exception ex) {
      System.out.println("Server is already in use - LOL");
    }
  }

  /** Stops the server */
  public void stop() {
    server.stop();
  }

  /**
   * Gets the number of clients connected
   *
   * @return number of connections
   */
  public int numConnections() {
    return ServerEndpoint.peers.size();
  }

  /**
   * Sends a status object of the websocket
   *
   * @param status status object to be sent
   */
  public void sendStatus(Status status) {
    for (Session peer : ServerEndpoint.peers) {
      try {
        peer.getBasicRemote().sendObject(status);
        Console.setMessage("Data Sent to Client");
      } catch (IOException | EncodeException e) {
        Console.setErrorMessage("Error while sending data to client");
        e.printStackTrace();
      }
    }
  }
}
