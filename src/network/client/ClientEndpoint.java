package network.client;

import network.model.Status;
import network.model.StatusDecoder;
import network.model.StatusEncoder;
import network.model.StatusObservable;
import view.server.components.Console;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import java.io.IOException;

import static java.lang.String.format;

@javax.websocket.ClientEndpoint(encoders = StatusEncoder.class, decoders = StatusDecoder.class)
public class ClientEndpoint {

    @OnClose
    public void onClose(Session session) {
        view.client.Client.updateIsServerRunning(false);
    }

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

    @OnMessage
    public void onMessage(Status status) {
    		StatusObservable.getObserverInstance().addStatus(status);
    }


}
