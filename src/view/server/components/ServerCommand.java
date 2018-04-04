package view.server.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerCommand {

    /**
     * @wbp.parser.entryPoint
     */
    public static JPanel getPanel() {
        JPanel serverCommand = new JPanel();
        serverCommand.setBackground(new Color(255, 218, 185));

        serverCommand.setPreferredSize(new Dimension(520, 190));
        serverCommand.setLayout(null);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 600, 31);
        serverCommand.add(menuBar);
        
        JMenu menuApplication = new JMenu("Application");
        menuApplication.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        menuBar.add(menuApplication);
        
        JMenuItem mntmQuit = new JMenuItem("Quit");
        mntmQuit.setVerticalTextPosition(SwingConstants.TOP);
        mntmQuit.setVerticalAlignment(SwingConstants.TOP);
        menuApplication.add(mntmQuit);
        
        JMenu mnHelp = new JMenu("Help");
        mnHelp.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        menuBar.add(mnHelp);
        
        JMenuItem mntmAbout = new JMenuItem("About");
        mntmAbout.setVerticalTextPosition(SwingConstants.TOP);
        mntmAbout.setVerticalAlignment(SwingConstants.TOP);
        mntmAbout.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        mnHelp.add(mntmAbout);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 30, 670, 160);
        serverCommand.add(tabbedPane);
        
        JPanel tabInteractive = new JPanel();
        tabInteractive.setBackground(Color.WHITE);
        tabbedPane.addTab("Interactive", null, tabInteractive, null);
        tabInteractive.setLayout(null);
        
        Button startBtn = new Button("Start");
        startBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        startBtn.setBounds(379, 20, 126, 42);
        tabInteractive.add(startBtn);
        
        Checkbox autoRepeatcheckbox = new Checkbox("Auto Repeat");
        autoRepeatcheckbox.setBounds(46, 66, 174, 27);
        tabInteractive.add(autoRepeatcheckbox);
        
        JLabel lblEmoState = new JLabel("EmoState Interval ");
        lblEmoState.setBounds(25, 20, 160, 20);
        tabInteractive.add(lblEmoState);
        
        JSpinner intervalSpinner = new JSpinner();
        intervalSpinner.setAutoscrolls(true);
        intervalSpinner.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        intervalSpinner.setModel(new SpinnerListModel(new String[] {"0.10", "0.20", "0.30"}));
        intervalSpinner.setBounds(152, 20, 68, 26);
        tabInteractive.add(intervalSpinner);
        
        JLabel labelSec = new JLabel("sec");
        labelSec.setBounds(226, 20, 69, 20);
        tabInteractive.add(labelSec);

        return serverCommand;
    }
}
