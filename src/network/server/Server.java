package network.server;

import network.model.Status;
import view.server.components.Console;

import javax.websocket.DeploymentException;
import javax.websocket.EncodeException;
import javax.websocket.Session;

import java.io.IOException;

import static util.NetworkConstants.PORT;
import static util.NetworkConstants.HOST;
import static util.NetworkConstants.ROOT_PATH;

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

	public void start(String host, int port) {
		try {
			server = new org.glassfish.tyrus.server.Server(host, port, "/" + ROOT_PATH, ServerEndpoint.class);
			server.start();
		} catch (DeploymentException e) {
			e.printStackTrace();
		}
	}

	public void stop() {
		server.stop();
	}

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
