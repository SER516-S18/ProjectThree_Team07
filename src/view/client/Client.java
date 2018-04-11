package view.client;

import network.model.Connection;
import util.ClientConstants;
import util.NetworkConstants;
import util.ServerConstants;
import view.client.components.affective.AffectiveTab;
import view.client.components.affective.AffectiveTimeSeriesGraph;
import view.client.components.expressive.ExpressiveTimeSeriesGraph;
import view.client.components.expressive.FacialExpressions;

import controller.client.ServerLauncher;
import javax.swing.*;

import java.awt.*;

import controller.client.FacialExpressionSolver;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** @author Team 7 Client View */
public class Client {
  private static boolean isServerReady = false;
  private static JLabel showStatusValLabel;
  private static JLabel showTimestampValLabel;

  public static JLabel getTimestampValLabel() {
    return showTimestampValLabel;
  }

  private static JLabel createLabelStatus() {
    JLabel lblStatus = new JLabel(ClientConstants.STATUS_LABEL);
    lblStatus.setBounds(665, 27, 90, 14);
    lblStatus.setFont(new Font(ClientConstants.FONT_TYPE, Font.PLAIN, 16));
    lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
    return lblStatus;
  }

  private static JLabel createShowStatusLabel() {
    showStatusValLabel = new JLabel("");
    showStatusValLabel.setBounds(750, 27, 100, 14);
    showStatusValLabel.setFont(new Font(ClientConstants.FONT_TYPE, Font.PLAIN, 16));
    return showStatusValLabel;
  }

  private static JFrame createClientFrame() {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame clientFrame = new JFrame(ClientConstants.TITLE);
    clientFrame.getContentPane().setBackground(Color.WHITE);
    clientFrame.setName(ClientConstants.FRAME_NAME);
    clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    clientFrame.getContentPane().setLayout(null);
    clientFrame.setPreferredSize(new Dimension(1000, 700));
    return clientFrame;
  }

  private static JLabel createTimestampLabel() {
    JLabel lblTimeStamp = new JLabel(ClientConstants.TIMESTAMP_LABEL);
    lblTimeStamp.setBounds(650, 55, 90, 14);
    lblTimeStamp.setFont(new Font(ClientConstants.FONT_TYPE, Font.PLAIN, 16));
    return lblTimeStamp;
  }

  private static JLabel createShowTimestampValLabel() {
    showTimestampValLabel = new JLabel(ClientConstants.TIMESTAMP_VALUE_LABEL);
    showTimestampValLabel.setBounds(750, 55, 100, 14);
    showTimestampValLabel.setFont(new Font(ClientConstants.FONT_TYPE, Font.PLAIN, 16));
    return showTimestampValLabel;
  }

  private static JButton createInterestButton() {
    JButton btnInterest = new JButton(ClientConstants.INTEREST_LABEL);
    btnInterest.setBounds(60, 60, 140, 100);
    btnInterest.setBackground(AffectiveTimeSeriesGraph.getinstance().getInterestColor());
    btnInterest.setOpaque(true);
    btnInterest.setBorderPainted(true);
    if (AffectiveTimeSeriesGraph.getinstance().getInterestColor() == Color.black) {
      btnInterest.setForeground(Color.WHITE);
    }
    btnInterest.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            Color initialBackground = AffectiveTimeSeriesGraph.getinstance().getInterestColor();
            Color newBackground =
                JColorChooser.showDialog(
                    null,
                    ClientConstants.COLOR_CHANGE_DIALOG_TITLE + ServerConstants.INTEREST + " Color",
                    initialBackground);
            if (newBackground != null) {
              AffectiveTimeSeriesGraph.getinstance().setInterestColor(newBackground);
              AffectiveTimeSeriesGraph.getinstance().updateGraph();
              btnInterest.setBackground(newBackground);
              btnInterest.setOpaque(true);
              btnInterest.setBorderPainted(true);
              // splitPanePerformance.setLeftComponent(AffectiveTab.getPanel());
            }
          }
        });
    return btnInterest;
  }

  private static JButton createExcitementButton() {
    JButton btnExcitement = new JButton(ClientConstants.EXCITEMENT_LABEL);
    btnExcitement.setBounds(240, 60, 140, 100);
    btnExcitement.setBackground(AffectiveTimeSeriesGraph.getinstance().getExcitementColor());
    if (AffectiveTimeSeriesGraph.getinstance().getExcitementColor() == Color.black) {
      btnExcitement.setForeground(Color.WHITE);
    }
    btnExcitement.setOpaque(true);
    btnExcitement.setBorderPainted(true);
    btnExcitement.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Color initialBackground = AffectiveTimeSeriesGraph.getinstance().getExcitementColor();
            Color newBackground =
                JColorChooser.showDialog(
                    null,
                    ClientConstants.COLOR_CHANGE_DIALOG_TITLE
                        + ServerConstants.EXCITEMENT
                        + " Color",
                    initialBackground);
            if (newBackground != null) {
              AffectiveTimeSeriesGraph.getinstance().setExcitementColor(newBackground);
              AffectiveTimeSeriesGraph.getinstance().updateGraph();
              btnExcitement.setBackground(newBackground);
              btnExcitement.setOpaque(true);
              btnExcitement.setBorderPainted(true);
            }
          }
        });
    return btnExcitement;
  }

  private static JButton createEngagementButton() {
    JButton btnEngagement = new JButton(ClientConstants.ENGAGEMENT_LABEL);
    btnEngagement.setBounds(60, 210, 140, 100);
    btnEngagement.setBackground(AffectiveTimeSeriesGraph.getinstance().getEngagementColor());
    btnEngagement.setOpaque(true);
    btnEngagement.setBorderPainted(true);
    if (AffectiveTimeSeriesGraph.getinstance().getEngagementColor() == Color.black) {
      btnEngagement.setForeground(Color.WHITE);
    }
    btnEngagement.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Color initialBackground = AffectiveTimeSeriesGraph.getinstance().getEngagementColor();
            Color newBackground =
                JColorChooser.showDialog(
                    null,
                    ClientConstants.COLOR_CHANGE_DIALOG_TITLE
                        + ServerConstants.ENGAGEMENT
                        + " Color",
                    initialBackground);
            if (newBackground != null) {
              AffectiveTimeSeriesGraph.getinstance().setEngagementColor(newBackground);
              AffectiveTimeSeriesGraph.getinstance().updateGraph();
              btnEngagement.setBackground(newBackground);
              btnEngagement.setOpaque(true);
              btnEngagement.setBorderPainted(true);
            }
          }
        });
    return btnEngagement;
  }

  private static JButton createStressButton() {
    JButton btnStress = new JButton(ClientConstants.STRESS_LABEL);
    btnStress.setBounds(240, 210, 140, 100);
    btnStress.setBackground(AffectiveTimeSeriesGraph.getinstance().getStressColor());
    btnStress.setOpaque(true);
    btnStress.setBorderPainted(true);
    if (AffectiveTimeSeriesGraph.getinstance().getStressColor() == Color.black) {
      btnStress.setForeground(Color.WHITE);
    }
    btnStress.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Color initialBackground = AffectiveTimeSeriesGraph.getinstance().getStressColor();
            Color newBackground =
                JColorChooser.showDialog(
                    null,
                    ClientConstants.COLOR_CHANGE_DIALOG_TITLE + ServerConstants.STRESS + " Color",
                    initialBackground);
            if (newBackground != null) {
              AffectiveTimeSeriesGraph.getinstance().setStressColor(newBackground);
              AffectiveTimeSeriesGraph.getinstance().updateGraph();
              btnStress.setBackground(newBackground);
              btnStress.setOpaque(true);
              btnStress.setBorderPainted(true);
              // splitPanePerformance.setLeftComponent(AffectiveTab.getPanel());
            }
          }
        });
    return btnStress;
  }

  private static JButton createRelaxationButton() {
    JButton btnRelaxation = new JButton(ClientConstants.RELAXATION_LABEL);
    btnRelaxation.setBounds(60, 370, 140, 100);
    btnRelaxation.setBackground(AffectiveTimeSeriesGraph.getinstance().getRelaxationColor());
    btnRelaxation.setOpaque(true);
    btnRelaxation.setBorderPainted(true);
    if (AffectiveTimeSeriesGraph.getinstance().getRelaxationColor() == Color.black) {
      btnRelaxation.setForeground(Color.BLACK);
    }
    btnRelaxation.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Color initialBackground = AffectiveTimeSeriesGraph.getinstance().getRelaxationColor();
            Color newBackground =
                JColorChooser.showDialog(
                    null,
                    ClientConstants.COLOR_CHANGE_DIALOG_TITLE
                        + ServerConstants.RELAXATION
                        + " Color",
                    initialBackground);
            if (newBackground != null) {
              AffectiveTimeSeriesGraph.getinstance().setRelaxationColor(newBackground);
              AffectiveTimeSeriesGraph.getinstance().updateGraph();
              btnRelaxation.setBackground(newBackground);
              btnRelaxation.setOpaque(true);
              btnRelaxation.setBorderPainted(true);
            }
          }
        });
    return btnRelaxation;
  }

  private static JButton createFocusButton() {
    JButton btnFocus = new JButton(ClientConstants.FOCUS_LABEL);
    btnFocus.setBounds(240, 370, 140, 100);
    btnFocus.setBackground(AffectiveTimeSeriesGraph.getinstance().getFocusColor());
    btnFocus.setOpaque(true);
    btnFocus.setBorderPainted(true);
    if (AffectiveTimeSeriesGraph.getinstance().getFocusColor() == Color.black) {
      btnFocus.setForeground(Color.WHITE);
    }
    btnFocus.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Color initialBackground = AffectiveTimeSeriesGraph.getinstance().getFocusColor();
            Color newBackground =
                JColorChooser.showDialog(
                    null,
                    ClientConstants.COLOR_CHANGE_DIALOG_TITLE + ServerConstants.FOCUS + " Color",
                    initialBackground);
            if (newBackground != null) {
              AffectiveTimeSeriesGraph.getinstance().setFocusColor(newBackground);
              AffectiveTimeSeriesGraph.getinstance().updateGraph();
              btnFocus.setBackground(newBackground);
              btnFocus.setOpaque(true);
              btnFocus.setBorderPainted(true);
              // splitPanePerformance.setLeftComponent(AffectiveTab.getPanel());
            }
          }
        });
    return btnFocus;
  }

  /** Create anf SHow Client GUI */
  private static void createAndShowClientGUI() {
    JFrame clientFrame = createClientFrame();
    clientFrame.getContentPane().add(createLabelStatus());
    clientFrame.getContentPane().add(createShowStatusLabel());
    setServerReadyLabel();
    clientFrame.getContentPane().add(createTimestampLabel());
    clientFrame.getContentPane().add(createShowTimestampValLabel());
    JTextField hostField = new JTextField(8);
    JTextField portField = new JTextField(5);
    hostField.setText(Connection.getInstance().getHost());
    portField.setText(String.valueOf(Connection.getInstance().getPort()));
    JPanel connectToServerPanel = new JPanel();
    connectToServerPanel.add(new JLabel(ClientConstants.HOST_LABEL));
    connectToServerPanel.add(hostField);
    connectToServerPanel.add(new JLabel(ClientConstants.PORT_LABEL));
    connectToServerPanel.add(portField);
    JPanel errorPanel = new JPanel();
    errorPanel.add(new JLabel(ClientConstants.CONNECT_ERROR_MESSAGE));
    JButton btnConnect = new JButton(ClientConstants.CONNECT_BUTTON_LABEL);
    btnConnect.setBounds(180, 52, 180, 23);
    btnConnect.setFont(new Font(ClientConstants.FONT_TYPE, Font.PLAIN, 16));
    btnConnect.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            int result =
                JOptionPane.showConfirmDialog(
                    null,
                    connectToServerPanel,
                    ClientConstants.CONNECT_DIALOG_MESSAGE,
                    JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
              if (hostField.getText().equals(Connection.getInstance().getHost())
                  && portField.getText().equals(String.valueOf(Connection.getInstance().getPort()))
                  && view.server.Server.isServerUp) {
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
    tabbedPane.addTab(ClientConstants.PERFORMANCE_TAB_TITLE, null, splitPanePerformance, null);
    splitPanePerformance.setLeftComponent(AffectiveTab.getPanel());
    Panel btnPanel = new Panel();
    btnPanel.setBackground(Color.WHITE);
    splitPanePerformance.setRightComponent(btnPanel);
    btnPanel.setLayout(null);
    btnPanel.add(createInterestButton());
    btnPanel.add(createExcitementButton());
    btnPanel.add(createEngagementButton());
    btnPanel.add(createStressButton());
    btnPanel.add(createRelaxationButton());
    btnPanel.add(createFocusButton());
    JLabel lblDisplayLength = new JLabel(ClientConstants.DISPLAY_LENGTH_LABEL);
    lblDisplayLength.setBounds(140, 500, 130, 20);
    btnPanel.add(lblDisplayLength);
    JLabel lblDisplayLengthValue =
        new JLabel(
            Integer.toString(
                AffectiveTimeSeriesGraph.getinstance().getDisplayLength().intValue() / 1000));
    lblDisplayLengthValue.setBounds(260, 500, 50, 20);
    btnPanel.add(lblDisplayLengthValue);
    JLabel labelSec = new JLabel(ClientConstants.SEC_LABEL);
    labelSec.setBounds(300, 500, 50, 20);
    btnPanel.add(labelSec);
    JSplitPane splitPaneExpressive = new JSplitPane();
    tabbedPane.addTab(ClientConstants.EXPRESSIVE_TAB, null, splitPaneExpressive, null);
    splitPaneExpressive.setDividerLocation(490);
    splitPaneExpressive.setLeftComponent(FacialExpressions.getPanel());
    splitPaneExpressive.setRightComponent(ExpressiveTimeSeriesGraph.getinstance().getPanel());
    JButton btnOpenServer = new JButton(ClientConstants.EMO_COMPOSER_BUTTON_TEXT);
    btnOpenServer.setBounds(180, 25, 180, 23);
    btnOpenServer.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            if (!view.server.Server.isServerUp) {
              ServerLauncher.serverLauncherFactory();
            }
          }
        });
    btnOpenServer.setFont(new Font(ClientConstants.FONT_TYPE, Font.PLAIN, 16));
    clientFrame.getContentPane().add(btnOpenServer);
    clientFrame.setVisible(true);
    clientFrame.pack();
    clientFrame.setResizable(false);
  }

  private static void setServerReadyLabel() {
    if (isServerReady) {
      showStatusValLabel.setText(ClientConstants.SERVER_STATUS_TEXT_SUCCESS);
      showStatusValLabel.setForeground(Color.GREEN);
    } else {
      showStatusValLabel.setText(ClientConstants.SERVER_STATUS_TEXT_UNSUCCESS);
      showStatusValLabel.setForeground(Color.RED);
    }
  }

  public static void updateIsServerRunning(boolean serverStatus) {
    isServerReady = serverStatus;
    setServerReadyLabel();
  }

  public static void main(String[] args) {
    createAndShowClientGUI();
    // Loop - Pooling for the connection
    for (; ; ) {}
  }
}
