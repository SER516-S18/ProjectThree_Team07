package view.client.components;

import javax.swing.*;
import java.awt.*;

public class ConnectedStatus {

    public static JPanel getPanel() {
        JPanel connectedStatus = new JPanel();
        connectedStatus.setPreferredSize(new Dimension(100, 100));

        JLabel instructions = new JLabel("Status showing connected or not", JLabel.CENTER);
        connectedStatus.add(instructions);

        connectedStatus.setBackground(Color.decode("#C9C9C9"));

        return connectedStatus;
    }
}
