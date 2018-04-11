package network.client;

import network.model.*;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import java.io.IOException;

import static java.lang.String.format;

/**
 * Client endpoint the websocket server hits
 *
 * @author team 7
 */
@javax.websocket.ClientEndpoint(encoders = StatusEncoder.class, decoders = StatusDecoder.class)
public class ClientEndpoint {

  /**
   * Called when the connected serer ends its connection
   *
   * @param session session object of the client
   */
  @OnClose
  public void onClose(Session session) {
    view.client.Client.updateIsServerRunning(false);
    //        Connection.getInstance().setLaunched(false);
  }

  /**
   * Called when the client makes a successful connection to a server
   *
   * @param session session object of the client
   */
  @OnOpen
  public void onOpen(Session session) {
    System.out.println(format("Connection established. session id: %s", session.getId()));
    try {
      session.getBasicRemote().sendText("start");
      view.client.Client.updateIsServerRunning(true);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Called when the client receives a message from the server
   *
   * @param status the status object received from the server
   */
  @OnMessage
  public void onMessage(Status status) {
    StatusObservable.getObserverInstance().addStatus(status);
  }
}
