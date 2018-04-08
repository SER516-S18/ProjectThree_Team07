package view.client;

import view.client.components.affective.AffectiveTab;
import view.client.components.ConnectedStatus;
import view.client.components.expressive.ExpressionTab;

import java.awt.*;
import javax.swing.*;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client {

    private static void addComponentsToPane(Container contentPane) {
    }

    private static void createAndShowClientGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame clientFrame = new JFrame("Emotiv Xavier Control Panel");
        clientFrame.getContentPane().setBackground(Color.White);
        clientFrame.setName("frame212");
        clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientFrame.getContentPane().setLayout(null);
       
        
        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(205, 27, 146, 17);
        lblStatus.setAlignmentX(Component.RIGHT_ALIGNMENT);
        lblStatus.setAlignmentY(Component.TOP_ALIGNMENT);
        lblStatus.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
        clientFrame.getContentPane().add(lblStatus);
        
        JLabel lblTimeStamp = new JLabel("Time Stamp:");
        lblTimeStamp.setBounds(260, 55, 90, 14);
        lblTimeStamp.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        clientFrame.getContentPane().add(lblTimeStamp);
        
        JButton btnConnect = new JButton("Connect Server");
        btnConnect.setForeground(Color.BLACK);
        btnConnect.setBackground(Color.WHITE);
        btnConnect.setBounds(36, 52, 146, 23);
        btnConnect.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnConnect.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        clientFrame.getContentPane().add(btnConnect);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(442, 123, -428, -8);
        clientFrame.getContentPane().add(separator);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 86, 469, 369);
        clientFrame.getContentPane().add(tabbedPane);
        
        JSplitPane splitPane = new JSplitPane();
        tabbedPane.addTab("Performance Metrics", null, splitPane, null);
        
        Panel panel = new Panel();
        panel.setBackground(Color.WHITE);
        panel.setForeground(new Color(255, 255, 255));
        splitPane.setLeftComponent(panel);
        panel.setLayout(null);
        
        Panel panel_1 = new Panel();
        panel_1.setBackground(Color.WHITE);
        splitPane.setRightComponent(panel_1);
        panel_1.setLayout(null);
        
        JButton btnInterest = new JButton("Interest");
        btnInterest.setBackground(Color.WHITE);
        btnInterest.setBounds(23, 35, 82, 62);
        panel_1.add(btnInterest);
        
        JButton btnNewButton = new JButton("Excitement");
        btnNewButton.setBounds(23, 242, 82, 62);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        JButton btnEngagement = new JButton("Engagement");
        btnEngagement.setBounds(125, 35, 82, 62);
        panel_1.add(btnEngagement);
        
        JButton btnStress = new JButton("Stress");
        btnStress.setBounds(23, 141, 82, 62);
        panel_1.add(btnStress);
        
        JButton btnRelaxation = new JButton("Relaxation");
        btnRelaxation.setBounds(125, 141, 82, 62);
        panel_1.add(btnRelaxation);
        panel_1.add(btnNewButton);
        
        JButton btnFocus = new JButton("Focus");
        btnFocus.setBounds(125, 242, 82, 62);
        panel_1.add(btnFocus);
        splitPane.setDividerLocation(230);
        
        JSplitPane splitPane_1 = new JSplitPane();
        tabbedPane.addTab("Expressiv Suite", null, splitPane_1, null);
        
        Panel panel_2 = new Panel();
        panel_2.setBackground(Color.WHITE);
        splitPane_1.setLeftComponent(panel_2);
        panel_2.setLayout(null);
        
        Panel panel_3 = new Panel();
        panel_3.setBackground(Color.WHITE);
        splitPane_1.setRightComponent(panel_3);
        panel_3.setLayout(null);
        splitPane_1.setDividerLocation(230);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(361, 29, 46, 14);
        clientFrame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setBounds(360, 56, 46, 14);
        clientFrame.getContentPane().add(lblNewLabel_1);
        
        JButton btnOpenServer = new JButton("Open EmoComposer");
        btnOpenServer.setBounds(36, 25, 146, 23);
        btnOpenServer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnOpenServer.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        clientFrame.getContentPane().add(btnOpenServer);
    }

    public static void main(String[] args) {
        createAndShowClientGUI();
    }
}
