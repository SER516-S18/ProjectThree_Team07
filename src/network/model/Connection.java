package network.model;

/**
 * A singleton implementation of the current connection between a client and server
 *
 */
public class Connection {

    private static Connection connectionInstance = null;

    private String host = util.NetworkConstants.HOST;
    private int port = util.NetworkConstants.PORT;
    private boolean isLaunched;

//    public boolean isLaunched() {
//        return isLaunched;
//    }
//
//    public void setLaunched(boolean launched) {
//        isLaunched = launched;
//    }

    private Connection() {}

    public static Connection getInstance() {
        if (connectionInstance == null) {
            connectionInstance = new Connection();
        }
        return connectionInstance;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
