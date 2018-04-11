package view.server;

import view.server.components.Console;
import view.server.components.ServerCommand;
import view.server.components.attributes.AttributeContainer;
import java.io.File;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import static util.NetworkConstants.HOST;
import static util.NetworkConstants.PORT;

public class Server {
  public static Server serverViewInstance;
  public static JFrame serverView;
  public static boolean isServerUp;

  private static void addComponentsToPane(Container contentPane) {
    contentPane.setLayout(new BorderLayout(5, 5));
    contentPane.setBackground(Color.decode("#C5E0D8"));
    contentPane.add(ServerCommand.getPanel(), BorderLayout.PAGE_START);
    contentPane.add(AttributeContainer.getPanel(), BorderLayout.CENTER);
    contentPane.add(Console.getConsolePanel(), BorderLayout.PAGE_END);
  }

  public static Server getInstance() {
    if (serverViewInstance == null) {
      serverViewInstance = new Server();
    }
    isServerUp = true;
    return serverViewInstance;
  }

  public JFrame createAndShowServerGUI() {

    if(serverView == null) {
      JFrame.setDefaultLookAndFeelDecorated(true);
      serverView = new JFrame("Project 3 Team 7 - EmojiServer");
//      serverView.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      // set up the content pane and add swing components to it
      addComponentsToPane(serverView.getContentPane());
      serverView.setPreferredSize(new Dimension(1000, 800));
      serverView.pack();
      serverView.setResizable(false);
    }
    return serverView;
  }

  public static void main(String[] args) {
    network.server.Server server = network.server.Server.getInstance();

    if (args.length == 0) {
      // development server running off localhost
      server.start(HOST, PORT);
    } else {
      // production server launched from client
      server.start(args[0], Integer.valueOf(args[1]));
    }
    Server serverViewInstance = Server.getInstance();
    JFrame serverFrame = serverViewInstance.createAndShowServerGUI();
    serverFrame.setVisible(true);
    Console.setMessage("Server is ready");
  }
}
