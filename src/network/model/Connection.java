package network.model;

/**
 * @author Team 7
 * A singleton implementation of the current connection between a client and server
 *
 * */
public class Connection {

  private static Connection connectionInstance = null;
  private String host = util.NetworkConstants.HOST;
  private int port = util.NetworkConstants.PORT;
  private boolean isLaunched;

  private Connection() {}

  /**
   * Connection singleton instance
   * @return Connection instance
   */
  public static Connection getInstance() {
    if (connectionInstance == null) {
      connectionInstance = new Connection();
    }
    return connectionInstance;
  }

  /**
   * Getter for host
   * @return String host
   */
  public String getHost() {
    return host;
  }

  /**
   * Setter for Host
   * @param String host
   */
  public void setHost(String host) {
    this.host = host;
  }

  /**
   * Getter for Port
   * @return int port
   */
  public int getPort() {
    return port;
  }

  /**
   * Setter for port
   * @param int port
   */
  public void setPort(int port) {
    this.port = port;
  }
}
