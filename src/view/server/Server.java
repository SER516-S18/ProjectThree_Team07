package view.server;

import util.NetworkConstants;
import view.server.components.Console;
import view.server.components.ServerCommand;
import view.server.components.attributes.AttributeContainer;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import static util.NetworkConstants.HOST;
import static util.NetworkConstants.PORT;

public class Server {

    private static void addComponentsToPane(Container contentPane) {
        contentPane.setLayout(new BorderLayout(5,5));
        contentPane.setBackground(Color.decode("#C5E0D8"));

        contentPane.add(ServerCommand.getPanel(), BorderLayout.PAGE_START);

        contentPane.add(AttributeContainer.getPanel(), BorderLayout.CENTER);

        contentPane.add(Console.getConsolePanel(), BorderLayout.PAGE_END);
    }

    private static void createAndShowServerGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame serverFrame = new JFrame("Project 3 Team 7 - EmojiServer");
//        serverFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        serverFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.out.println("Closing Server Window");
                view.client.ServerInit serverInstance = view.client.ServerInit.getInstance();
                serverInstance.closeLock();
                serverInstance.deleteFile();
                serverFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });

        // set up the content pane and add swing components to it
        addComponentsToPane(serverFrame.getContentPane());
        serverFrame.setPreferredSize(new Dimension(1000,800));

        serverFrame.pack();
        serverFrame.setVisible(true);
        serverFrame.setResizable(false);
    }

    public static void main(String[] args) {
        network.server.Server server = network.server.Server.getInstance();

        if(args.length == 0) {
            // development server running off localhost
            server.start(HOST, PORT);
        } else {
            // production server launched from client
            server.start(args[0], Integer.valueOf(args[1]));
        }

        createAndShowServerGUI();
        Console.setMessage("Server is ready");
    }
}