package view.server.components;

import javax.swing.*;
import java.awt.*;

public class ServerCommand {

    public static JPanel getPanel() {
        JPanel serverCommand = new JPanel();

        JLabel instructions = new JLabel("Start/Stop, auto repeat, interval", JLabel.CENTER);
        serverCommand.add(instructions);

        serverCommand.setPreferredSize(new Dimension(600, 70));

        return serverCommand;
    }
}
