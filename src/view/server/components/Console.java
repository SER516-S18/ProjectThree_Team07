package view.server.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Console {

    /**
     * @wbp.parser.entryPoint
     */
    public static JPanel getPanel() {
        JPanel console = new JPanel();

        console.setPreferredSize(new Dimension(600, 190));
        console.setLayout(null);
        
        JLabel consoleLabel = new JLabel("Console");
        consoleLabel.setBounds(15, -1, 119, 27);
        consoleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        console.add(consoleLabel);
        
        JTextPane consoleTextPane = new JTextPane();
        consoleTextPane.setBounds(15, 30, 538, 103);
        consoleTextPane.setForeground(new Color(255, 0, 51));
        consoleTextPane.setBackground(new Color(255, 255, 255));
        console.add(consoleTextPane);
        
        JButton clrLogBtn = new JButton("ClearLog");
        clrLogBtn.setBounds(15, 147, 144, 27);
        clrLogBtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        clrLogBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        console.add(clrLogBtn);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(556, 30, 29, 103);
        console.add(scrollPane);
        
        JScrollBar scrollBarConsole = new JScrollBar();
        scrollPane.setViewportView(scrollBarConsole);
        return console;
    }
}
