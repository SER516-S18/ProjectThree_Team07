package view.client;

import view.client.components.affective.AffectiveTab;
import view.client.components.expressive.ExpressiveTimeSeriesGraph;
import view.client.components.expressive.FacialExpressions;

import java.awt.*;
import javax.swing.*;

import controller.client.FacialExpressionSolver;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client {

  private static void createAndShowClientGUI() {
    JFrame.setDefaultLookAndFeelDecorated(true);

    JFrame clientFrame = new JFrame("Emotiv Xavier Control Panel");
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

    JLabel showStatusValLabel = new JLabel("New label");
    showStatusValLabel.setBounds(750, 27, 100, 14);
    showStatusValLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    clientFrame.getContentPane().add(showStatusValLabel);

    JLabel lblTimeStamp = new JLabel("Time Stamp:");
    lblTimeStamp.setBounds(650, 55, 90, 14);
    lblTimeStamp.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    clientFrame.getContentPane().add(lblTimeStamp);

    JLabel showTimestampValLabel = new JLabel("New label");
    showTimestampValLabel.setBounds(750, 55, 100, 14);
    showTimestampValLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    clientFrame.getContentPane().add(showTimestampValLabel);

    JButton btnConnect = new JButton("Connect Server");
    btnConnect.setBounds(180, 52, 180, 23);
    btnConnect.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    btnConnect.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
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
    btnInterest.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });

    JButton btnExcitement = new JButton("Excitement");
    btnExcitement.setBackground(Color.WHITE);
    btnExcitement.setBounds(240, 60, 140, 100);
    btnPanel.add(btnExcitement);
    btnExcitement.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });

    JButton btnEngagement = new JButton("Engagement");
    btnEngagement.setBackground(Color.WHITE);
    btnEngagement.setBounds(60, 210, 140, 100);
    btnPanel.add(btnEngagement);

    JButton btnStress = new JButton("Stress");
    btnStress.setBackground(Color.WHITE);
    btnStress.setBounds(240, 210, 140, 100);
    btnPanel.add(btnStress);

    JButton btnRelaxation = new JButton("Relaxation");
    btnRelaxation.setBackground(Color.WHITE);
    btnRelaxation.setBounds(60, 370, 140, 100);
    btnPanel.add(btnRelaxation);

    JButton btnFocus = new JButton("Focus");
    btnFocus.setBackground(Color.WHITE);
    btnFocus.setBounds(240, 370, 140, 100);
    btnPanel.add(btnFocus);


    JSplitPane splitPaneExpressive = new JSplitPane();
    tabbedPane.addTab("Expressive Suite", null, splitPaneExpressive, null);
    splitPaneExpressive.setDividerLocation(490);

    splitPaneExpressive.setLeftComponent(FacialExpressions.getPanel());

    splitPaneExpressive.setRightComponent(ExpressiveTimeSeriesGraph.getinstance().getPanel());

    JButton btnOpenServer = new JButton("Open EmoComposer");
    btnOpenServer.setBounds(180, 25, 180, 23);
    btnOpenServer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    btnOpenServer.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    clientFrame.getContentPane().add(btnOpenServer);
    clientFrame.setVisible(true);
    clientFrame.pack();
    clientFrame.setResizable(false);

  }
  
  //TODO to be removed after testing
  public static void testFacialExpression() {

	  for (FacialExpressionSolver.UpperFace upperFace : FacialExpressionSolver.UpperFace.values()) {
			for (FacialExpressionSolver.LowerFace lowerFace : FacialExpressionSolver.LowerFace.values()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				ImageLoader.loadImage(FacialExpressions.getPanel(), upperFace.getFileName(), lowerFace.getFileName());
			}
		}
	  }
  
  }
  public static void main(String[] args) {
    createAndShowClientGUI();
    //TODO to be removed after testing
    testFacialExpression();
    //TODO Added temporary code to open client and make websockets up
    network.client.Client.getInstance().start();
    
    for(;;) {
    	
    }
  }
}
