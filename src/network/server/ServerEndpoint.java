package network.server;

import network.model.StatusDecoder;
import network.model.StatusEncoder;

import javax.websocket.*;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;
import static util.NetworkConstants.STATUS_ENDPOINT;

@javax.websocket.server.ServerEndpoint(value = "/" + STATUS_ENDPOINT, encoders = StatusEncoder.class, decoders = StatusDecoder.class)
public class ServerEndpoint {

    static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void onOpen(Session session) throws IOException {
        System.out.println(format("%s is connected.", session.getId()));
        peers.add(session);
    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        System.out.println(format("%s stopped its connection.", session.getId()));
        peers.remove(session);
    }
}