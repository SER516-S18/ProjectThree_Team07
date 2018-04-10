package view.client;

import network.model.Connection;
import util.NetworkConstants;
import util.ServerConstants;
import view.client.components.affective.AffectiveTab;
import view.client.components.affective.AffectiveTimeSeriesGraph;
import view.client.components.expressive.ExpressiveTimeSeriesGraph;
import view.client.components.expressive.FacialExpressions;

import java.awt.*;
import javax.swing.*;

import controller.client.FacialExpressionSolver;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client {
    private static boolean isServerReady = false;
    private static JLabel showStatusValLabel;
    private static JLabel showTimestampValLabel;

    public static JLabel getTimestampValLabel() {
        return showTimestampValLabel;
    }

    private static void createAndShowClientGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame clientFrame = new JFrame("Project 3 Team 7 - Emotiv Xavier Control Panel");
        clientFrame.getContentPane().setBackground(Color.WHITE);
        clientFrame.setName("frame212");
        clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientFrame.getContentPane().setLayout(null);
        clientFrame.setPreferredSize(new Dimension(1000, 700));

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(665, 27, 90, 14);
        lblStatus.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
        clientFrame.getContentPane().add(lblStatus);

        showStatusValLabel = new JLabel("");
        showStatusValLabel.setBounds(750, 27, 100, 14);
        showStatusValLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        clientFrame.getContentPane().add(showStatusValLabel);

        setServerReadyLabel();

        JLabel lblTimeStamp = new JLabel("Time Stamp:");
        lblTimeStamp.setBounds(650, 55, 90, 14);
        lblTimeStamp.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        clientFrame.getContentPane().add(lblTimeStamp);

        showTimestampValLabel = new JLabel("0.00");
        showTimestampValLabel.setBounds(750, 55, 100, 14);
        showTimestampValLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        clientFrame.getContentPane().add(showTimestampValLabel);

        JTextField hostField = new JTextField(8);
        JTextField portField = new JTextField(5);

        hostField.setText(Connection.getInstance().getHost());
        portField.setText(String.valueOf(Connection.getInstance().getPort()));

        JPanel connectToServerPanel = new JPanel();
        connectToServerPanel.add(new JLabel("host:"));
        connectToServerPanel.add(hostField);
        connectToServerPanel.add(new JLabel("port:"));
        connectToServerPanel.add(portField);

        JPanel errorPanel = new JPanel();
        errorPanel.add(new JLabel("Cannot connect to server with the given host and port."));

        JButton btnConnect = new JButton("Connect Server");
        btnConnect.setBounds(180, 52, 180, 23);
        btnConnect.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnConnect.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int result =
                                JOptionPane.showConfirmDialog(
                                        null,
                                        connectToServerPanel,
                                        "Please Enter the Host and Port",
                                        JOptionPane.OK_CANCEL_OPTION);
                        if (result == JOptionPane.OK_OPTION) {
                            System.out.println("ServerInit.isServerLeaunched in Client " + ServerInit.isServerLeaunched);
                            if (hostField.getText().equals(Connection.getInstance().getHost())
                                    && portField.getText().equals(String.valueOf(Connection.getInstance().getPort()))
                                    && ServerInit.isServerLeaunched) {
                                network.client.Client.getInstance().start();
                            } else {
                                JOptionPane.showConfirmDialog(null, errorPanel, "error", JOptionPane.PLAIN_MESSAGE);
                            }
                        }
                    }
                });
        clientFrame.getContentPane().add(btnConnect);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 86, 980, 580);
        clientFrame.getContentPane().add(tabbedPane);

        JSplitPane splitPanePerformance = new JSplitPane();
        splitPanePerformance.setDividerLocation(490);
        tabbedPane.addTab("Performance Metrics", null, splitPanePerformance, null);


        splitPanePerformance.setLeftComponent(AffectiveTab.getPanel());

        Panel btnPanel = new Panel();
        btnPanel.setBackground(Color.WHITE);
        splitPanePerformance.setRightComponent(btnPanel);
        btnPanel.setLayout(null);

        JButton btnInterest = new JButton("Interest");
        btnInterest.setBackground(Color.WHITE);
        btnInterest.setBounds(60, 60, 140, 100);
        btnPanel.add(btnInterest);
        btnInterest.setBackground(AffectiveTimeSeriesGraph.getinstance().getInterestColor());
        btnInterest.setOpaque(true);
        btnInterest.setBorderPainted(false);
        if(AffectiveTimeSeriesGraph.getinstance().getInterestColor()==Color.black){
            btnInterest.setForeground(Color.WHITE);
        }
        btnInterest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color initialBackground = AffectiveTimeSeriesGraph.getinstance().getInterestColor();
                Color newBackground = JColorChooser.showDialog(null, "Change " + ServerConstants.INTEREST + " Color",
                        initialBackground);
                if (newBackground != null) {
                    AffectiveTimeSeriesGraph.getinstance().setInterestColor(newBackground);
                    AffectiveTimeSeriesGraph.getinstance().updateGraph();
                    btnInterest.setBackground(newBackground);
                    btnInterest.setOpaque(true);
                    btnInterest.setBorderPainted(false);
                    //splitPanePerformance.setLeftComponent(AffectiveTab.getPanel());
                }
            }
        });

        JButton btnExcitement = new JButton("Excitement");


        btnExcitement.setBackground(Color.WHITE);
        btnExcitement.setBounds(240, 60, 140, 100);
        btnPanel.add(btnExcitement);
        btnExcitement.setBackground(AffectiveTimeSeriesGraph.getinstance().getExcitementColor());
        if(AffectiveTimeSeriesGraph.getinstance().getExcitementColor()==Color.black){
            btnExcitement.setForeground(Color.WHITE);
        }
        btnExcitement.setOpaque(true);
        btnExcitement.setBorderPainted(false);
        btnExcitement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color initialBackground = AffectiveTimeSeriesGraph.getinstance().getExcitementColor();
                Color newBackground = JColorChooser.showDialog(null, "Change " + ServerConstants.EXCITEMENT + " Color",
                        initialBackground);
                if (newBackground != null) {
                    AffectiveTimeSeriesGraph.getinstance().setExcitementColor(newBackground);
                    AffectiveTimeSeriesGraph.getinstance().updateGraph();
                    btnExcitement.setBackground(newBackground);
                    btnExcitement.setOpaque(true);
                    btnExcitement.setBorderPainted(false);
                    //splitPanePerformance.setLeftComponent(AffectiveTab.getPanel());
                }
            }
        });

        JButton btnEngagement = new JButton("Engagement");
        btnEngagement.setBackground(Color.WHITE);
        btnEngagement.setBounds(60, 210, 140, 100);
        btnPanel.add(btnEngagement);
        btnEngagement.setBackground(AffectiveTimeSeriesGraph.getinstance().getEngagementColor());
        btnEngagement.setOpaque(true);
        btnEngagement.setBorderPainted(false);
        if(AffectiveTimeSeriesGraph.getinstance().getEngagementColor()==Color.black){
            btnEngagement.setForeground(Color.WHITE);
        }
        btnEngagement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color initialBackground = AffectiveTimeSeriesGraph.getinstance().getEngagementColor();
                Color newBackground = JColorChooser.showDialog(null, "Change " + ServerConstants.ENGAGEMENT + " Color",
                        initialBackground);
                if (newBackground != null) {
                    AffectiveTimeSeriesGraph.getinstance().setEngagementColor(newBackground);
                    AffectiveTimeSeriesGraph.getinstance().updateGraph();
                    btnEngagement.setBackground(newBackground);
                    btnEngagement.setOpaque(true);
                    btnEngagement.setBorderPainted(false);
                    //splitPanePerformance.setLeftComponent(AffectiveTab.getPanel());
                }
            }
        });

        JButton btnStress = new JButton("Stress");
        btnStress.setBackground(Color.WHITE);
        btnStress.setBounds(240, 210, 140, 100);
        btnStress.setBackground(AffectiveTimeSeriesGraph.getinstance().getStressColor());
        btnStress.setOpaque(true);
        btnStress.setBorderPainted(false);
        if(AffectiveTimeSeriesGraph.getinstance().getStressColor()==Color.black){
            btnStress.setForeground(Color.WHITE);
        }
        btnPanel.add(btnStress);
        btnStress.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color initialBackground = AffectiveTimeSeriesGraph.getinstance().getStressColor();
                Color newBackground = JColorChooser.showDialog(null, "Change " + ServerConstants.STRESS + " Color",
                        initialBackground);
                if (newBackground != null) {
                    AffectiveTimeSeriesGraph.getinstance().setStressColor(newBackground);
                    AffectiveTimeSeriesGraph.getinstance().updateGraph();
                    btnStress.setBackground(newBackground);
                    btnStress.setOpaque(true);
                    btnStress.setBorderPainted(false);
                    //splitPanePerformance.setLeftComponent(AffectiveTab.getPanel());
                }
            }
        });

        JButton btnRelaxation = new JButton("Relaxation");
        btnRelaxation.setBackground(Color.WHITE);
        btnRelaxation.setBounds(60, 370, 140, 100);
        btnPanel.add(btnRelaxation);
        btnRelaxation.setBackground(AffectiveTimeSeriesGraph.getinstance().getRelaxationColor());
        btnRelaxation.setOpaque(true);
        btnRelaxation.setBorderPainted(false);
        if(AffectiveTimeSeriesGraph.getinstance().getRelaxationColor()==Color.black){
            btnRelaxation.setForeground(Color.WHITE);
        }
        btnRelaxation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color initialBackground = AffectiveTimeSeriesGraph.getinstance().getRelaxationColor();
                Color newBackground = JColorChooser.showDialog(null, "Change " + ServerConstants.RELAXATION + " Color",
                        initialBackground);
                if (newBackground != null) {
                    AffectiveTimeSeriesGraph.getinstance().setRelaxationColor(newBackground);
                    AffectiveTimeSeriesGraph.getinstance().updateGraph();
                    btnRelaxation.setBackground(newBackground);
                    btnRelaxation.setOpaque(true);
                    btnRelaxation.setBorderPainted(false);
                    //splitPanePerformance.setLeftComponent(AffectiveTab.getPanel());
                }
            }
        });

        JButton btnFocus = new JButton("Focus");
        btnFocus.setBackground(Color.WHITE);
        btnFocus.setBounds(240, 370, 140, 100);
        btnFocus.setBackground(AffectiveTimeSeriesGraph.getinstance().getFocusColor());
        btnFocus.setOpaque(true);
        btnFocus.setBorderPainted(false);
        if(AffectiveTimeSeriesGraph.getinstance().getFocusColor()==Color.black){
            btnFocus.setForeground(Color.WHITE);
        }
        btnPanel.add(btnFocus);
        btnFocus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color initialBackground = AffectiveTimeSeriesGraph.getinstance().getFocusColor();
                Color newBackground = JColorChooser.showDialog(null, "Change " + ServerConstants.FOCUS + " Color",
                        initialBackground);
                if (newBackground != null) {
                    AffectiveTimeSeriesGraph.getinstance().setFocusColor(newBackground);
                    AffectiveTimeSeriesGraph.getinstance().updateGraph();
                    btnFocus.setBackground(newBackground);
                    btnFocus.setOpaque(true);
                    btnFocus.setBorderPainted(false);
                    //splitPanePerformance.setLeftComponent(AffectiveTab.getPanel());
                }
            }
        });


        JSplitPane splitPaneExpressive = new JSplitPane();
        tabbedPane.addTab("Expressive Suite", null, splitPaneExpressive, null);
        splitPaneExpressive.setDividerLocation(490);

        splitPaneExpressive.setLeftComponent(FacialExpressions.getPanel());

        splitPaneExpressive.setRightComponent(ExpressiveTimeSeriesGraph.getinstance().getPanel());

        JButton btnOpenServer = new JButton("Open EmoComposer");
        btnOpenServer.setBounds(180, 25, 180, 23);

        btnOpenServer.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ServerInit.loadServer(NetworkConstants.HOST, String.valueOf(NetworkConstants.PORT));
                    }
                });

        btnOpenServer.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        clientFrame.getContentPane().add(btnOpenServer);
        clientFrame.setVisible(true);
        clientFrame.pack();
        clientFrame.setResizable(false);

    }

    private static void setServerReadyLabel() {
        if (isServerReady) {
            showStatusValLabel.setText("Connected");
            showStatusValLabel.setForeground(Color.GREEN);
        } else {
            showStatusValLabel.setText("Not Connected");
            showStatusValLabel.setForeground(Color.RED);
        }
    }

    public static void updateIsServerRunning(boolean serverStatus) {
        isServerReady = serverStatus;
        setServerReadyLabel();
    }

    // TODO to be removed after testing
    public static void testFacialExpression() {

        for (FacialExpressionSolver.UpperFace upperFace : FacialExpressionSolver.UpperFace.values()) {
            for (FacialExpressionSolver.LowerFace lowerFace : FacialExpressionSolver.LowerFace.values()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                ImageLoader.loadImage(
                        FacialExpressions.getPanel(), upperFace.getFileName(), lowerFace.getFileName());
            }
        }
    }

    public static void main(String[] args) {
        createAndShowClientGUI();
        // TODO to be removed after testing
        // testFacialExpression();
        for (; ; ) {
        }
    }
}
