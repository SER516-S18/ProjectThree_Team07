package view.server.components;

import javax.swing.*;

import controller.server.MessageTimer;
import view.server.components.attributes.AttributeContainer;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class ServerCommand {

    private static JSpinner intervalSpinner;

	/**
     * @wbp.parser.entryPoint
     */
    public static JPanel getPanel() {
        JPanel serverCommand = new JPanel();
        serverCommand.setBackground(new Color(255, 218, 185));

        serverCommand.setPreferredSize(new Dimension(520, 190));
        serverCommand.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 30, 670, 160);
        serverCommand.add(tabbedPane);
        
        JPanel tabInteractive = new JPanel();
        tabInteractive.setBackground(Color.WHITE);
        tabbedPane.addTab("Interactive", null, tabInteractive, null);
        tabInteractive.setLayout(null);
        
        Checkbox autoRepeatcheckbox = new Checkbox("Auto Repeat");
        autoRepeatcheckbox.setBounds(46, 66, 174, 27);
        tabInteractive.add(autoRepeatcheckbox);
        
        
        JLabel lblEmoState = new JLabel("EmoState Interval ");
        lblEmoState.setBounds(25, 20, 160, 20);
        tabInteractive.add(lblEmoState);
        
        intervalSpinner = new JSpinner();
        intervalSpinner.setAutoscrolls(true);
        intervalSpinner.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        intervalSpinner.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(intervalSpinner);
        intervalSpinner.setEditor(editor);
        intervalSpinner.setBounds(152, 20, 68, 26);
        tabInteractive.add(intervalSpinner);
        
        JLabel labelSec = new JLabel("sec");
        labelSec.setBounds(226, 20, 69, 20);
        tabInteractive.add(labelSec);
        JButton startButton = new JButton("Send");
        
        startButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        startButton.setBounds(344, 16, 115, 60);
        tabInteractive.add(startButton);
        
        startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(startButton.isEnabled()) {
					String btnText= startButton.getText();
					if(btnText.equals("Start")) {
						MessageTimer.getInstance().setAutoRepeated(true);
						MessageTimer.getInstance().startTimer((double) intervalSpinner.getValue());
						startButton.setText("Stop");
					} else if(btnText.equals("Stop")) {
						MessageTimer.getInstance().stopTimer();
						startButton.setText("Start");
					} else {
						MessageTimer.getInstance().setAutoRepeated(false);
						MessageTimer.getInstance().startTimer((double) intervalSpinner.getValue());
						startButton.setText("Send");			
					}
				}
			}
		});
          
        
        autoRepeatcheckbox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(autoRepeatcheckbox.getState())
				{
					startButton.setText("Start");
				}
				else if(!autoRepeatcheckbox.getState())
				{
					startButton.setText("Send");
				}
				else
					System.out.println("");
			}
		});
        	
       
          
          
        return serverCommand;
    }
}