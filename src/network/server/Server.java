package network.server;

import network.model.Status;

import javax.websocket.DeploymentException;
import javax.websocket.EncodeException;
import javax.websocket.Session;

import java.io.IOException;

import static util.NetworkConstants.PORT;
import static util.NetworkConstants.HOST;
import static util.NetworkConstants.ROOT_PATH;

public class Server {

	private org.glassfish.tyrus.server.Server server;

	public Server() {
		server = new org.glassfish.tyrus.server.Server(HOST, PORT, "/" + ROOT_PATH, ServerEndpoint.class);
	}

	public void start() {
		try {
			server.start();
		} catch (DeploymentException e) {
			e.printStackTrace();
		}
	}

	public void sendStatus(Status stat) {
		for (Session peer : ServerEndpoint.peers) {
			try {
				peer.getBasicRemote().sendObject(stat);
			} catch (IOException | EncodeException e) {
				e.printStackTrace();
			}
		}
	}


}
