package view.server;

import view.server.components.Console;
import view.server.components.ServerCommand;
import view.server.components.attributes.AttributeContainer;

import java.awt.*;
import javax.swing.*;

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

        JFrame clientFrame = new JFrame("Project 3 Team 7 Server");
        clientFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // set up the content pane and add swing components to it
        addComponentsToPane(clientFrame.getContentPane());

        clientFrame.pack();
        clientFrame.setVisible(true);
        clientFrame.setResizable(false);
    }

    public static void main(String[] args) {
        network.server.Server server = network.server.Server.getInstance();
        server.start();

        createAndShowServerGUI();
    }
}
