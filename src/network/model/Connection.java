package network.model;

public class Connection {

    private static Connection connectionInstance = null;

    private String host = util.NetworkConstants.HOST;
    private int port = util.NetworkConstants.PORT;

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
