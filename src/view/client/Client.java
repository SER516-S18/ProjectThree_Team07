package view.client;

import network.model.Status;
import view.client.components.affective.AffectiveTab;
import view.client.components.ConnectedStatus;
import view.client.components.affective.AffectiveTimeSeriesGraph;
import view.client.components.expressive.ExpressionTab;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Client {

    private static void addComponentsToPane(Container contentPane) throws InterruptedException{
        contentPane.setLayout(new BorderLayout(5,5));
        contentPane.setBackground(Color.decode("#C5E0D8"));

        contentPane.add(ConnectedStatus.getPanel(), BorderLayout.PAGE_START);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.setPreferredSize(new Dimension(900, 500));

        tabbedPane.add("Expressive", ExpressionTab.getPanel());
        tabbedPane.add("Affective", AffectiveTab.getPanel());

        contentPane.add(tabbedPane, BorderLayout.CENTER);
        /*Status status = new Status();
        int x =0;
        while (x < 20) {
            status.setMediation(new Random().nextDouble() * 100);
            status.setEngagementBoredom(new Random().nextDouble() * 100);
            status.setExcitementShortTerm(new Random().nextDouble() * 100);
            status.setExcitmentLongTerm(new Random().nextDouble() * 100);
            status.setFrustration(new Random().nextDouble() * 100);
            AffectiveTimeSeriesGraph.getinstance().update(status);
            Thread.sleep(1000);
            x++;
        }*/

    }

    private static void createAndShowClientGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame clientFrame = new JFrame("Project 3 Team 7 Client");
        clientFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // set up the content pane and add swing components to it
        try {
            addComponentsToPane(clientFrame.getContentPane());
        }catch(Exception e){
            e.printStackTrace();
        }

        clientFrame.pack();
        clientFrame.setVisible(true);
    }

    public static void main(String[] args) {
        createAndShowClientGUI();
    }
}
