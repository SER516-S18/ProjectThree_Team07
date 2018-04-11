package controller.client;

import static util.NetworkConstants.HOST;
import static util.NetworkConstants.PORT;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import view.server.components.Console;

/**
 * @author: Team 7
 * @apiNote: Factory for creating Server connection and view instance
 */
public class ServerLauncher {
  public static void serverLauncherFactory() {
    try {
      network.server.Server server = network.server.Server.getInstance();
      JFrame serverView = view.server.Server.getInstance().createAndShowServerGUI();
      serverView.setVisible(true);
      serverView.addWindowListener(
          new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
              super.windowClosing(e);
              server.stop();
              view.server.Server.isServerUp = false;
              serverView.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            }
          });
      server.start(HOST, PORT);
      Console.setMessage("Server is ready");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
