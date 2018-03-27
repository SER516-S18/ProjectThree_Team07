package view.client;

import view.client.components.affective.AffectiveTab;
import view.client.components.ConnectedStatus;
import view.client.components.expressive.ExpressionTab;

import java.awt.*;
import javax.swing.*;

public class Client {

    private static void addComponentsToPane(Container contentPane) {
        contentPane.setLayout(new BorderLayout(5,5));
        contentPane.setBackground(Color.decode("#C5E0D8"));

        contentPane.add(ConnectedStatus.getPanel(), BorderLayout.PAGE_START);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.setPreferredSize(new Dimension(900, 500));

        tabbedPane.add("Expressive", ExpressionTab.getPanel());
        tabbedPane.add("Affective", AffectiveTab.getPanel());

        contentPane.add(tabbedPane, BorderLayout.CENTER);
    }

    private static void createAndShowClientGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame clientFrame = new JFrame("Project 3 Team 7 Client");
        clientFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // set up the content pane and add swing components to it
        addComponentsToPane(clientFrame.getContentPane());

        clientFrame.pack();
        clientFrame.setVisible(true);
    }

    public static void main(String[] args) {
        createAndShowClientGUI();
    }
}
