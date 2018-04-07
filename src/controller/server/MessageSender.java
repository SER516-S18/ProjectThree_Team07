package controller.server;

import network.model.Status;
import network.server.Server;

/**
 * Class to hand message sending via network objects
 * @author raam
 *
 */
public class MessageSender {
	private static Server server = null;
	
	private static Server getServer() {
		if (server == null) {
			server = new Server();
		}
		return server;
	}
	
	/**
	 * 
	 * gets status object from server and sends to the client 
	 * 
	 */
	public static void sendData() {
		getServer().sendStatus();
	}
	
}
