package view.server.components;

import javax.swing.*;

import controller.server.MessageTimer;
import util.ServerConstants;
import view.client.components.expressive.FacialExpressions;
import view.server.components.attributes.AttributeContainer;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

/** @author Team 7 Server Command data view */
public class ServerCommand {

  private static JSpinner intervalSpinner;

  /** @wbp.parser.entryPoint */
  public static JPanel getPanel() {
    JPanel serverCommand = new JPanel();
    //        serverCommand.setBackground(new Color(255, 218, 185));

    serverCommand.setPreferredSize(new Dimension(1000, 150));
    serverCommand.setLayout(null);

    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    tabbedPane.setBounds(0, 6, 1000, 140);
    serverCommand.add(tabbedPane);

    JPanel tabInteractive = new JPanel();
    tabInteractive.setBackground(Color.WHITE);
    tabbedPane.addTab("Interactive", null, tabInteractive, null);
    tabInteractive.setLayout(null);

    Checkbox autoRepeatcheckbox = new Checkbox("Auto Repeat");
    autoRepeatcheckbox.setBounds(242, 50, 164, 27);
    tabInteractive.add(autoRepeatcheckbox);

    JLabel lblEmoState = new JLabel("EmoState Interval ");
    lblEmoState.setBounds(250, 20, 160, 20);
    tabInteractive.add(lblEmoState);

    intervalSpinner = new JSpinner();
    intervalSpinner.setAutoscrolls(true);
    intervalSpinner.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    intervalSpinner.setModel(new SpinnerNumberModel(0.25, 0.25, 100, 0.5));
    JSpinner.NumberEditor editor = new JSpinner.NumberEditor(intervalSpinner);
    intervalSpinner.setEditor(editor);
    intervalSpinner.setBounds(370, 20, 68, 26);
    tabInteractive.add(intervalSpinner);

    JLabel labelSec = new JLabel("sec");
    labelSec.setBounds(450, 20, 69, 20);
    tabInteractive.add(labelSec);
    JButton startButton = new JButton(ServerConstants.SEND);

    startButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    startButton.setBounds(600, 16, 115, 60);
    tabInteractive.add(startButton);

    startButton.addActionListener(
        new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
            if (startButton.isEnabled()) {
              String btnText = startButton.getText();
              if (btnText.equals(ServerConstants.START)) {
                MessageTimer.getInstance().startTimer((double) intervalSpinner.getValue(), true);
                FacialExpressions.getFileTypeCombo().setEnabled(false);
                startButton.setText(ServerConstants.STOP);
                autoRepeatcheckbox.setEnabled(false);
              } else if (btnText.equals(ServerConstants.STOP)) {
                MessageTimer.getInstance().stopTimer();
                FacialExpressions.getFileTypeCombo().setEnabled(true);
                startButton.setText(ServerConstants.START);
                autoRepeatcheckbox.setEnabled(true);

              } else {
                MessageTimer.getInstance().startTimer((double) intervalSpinner.getValue(), false);
                startButton.setText(ServerConstants.SEND);
              }
            }
          }
        });

    autoRepeatcheckbox.addItemListener(
        new ItemListener() {

          @Override
          public void itemStateChanged(ItemEvent e) {
            if (autoRepeatcheckbox.getState()) {
              startButton.setText(ServerConstants.START);
            } else if (!autoRepeatcheckbox.getState()) {
              startButton.setText(ServerConstants.SEND);
            } else System.out.println("");
          }
        });

    return serverCommand;
  }
}
