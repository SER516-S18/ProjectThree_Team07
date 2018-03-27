package view.server.components;

import javax.swing.*;
import java.awt.*;

public class Console {

    public static JPanel getPanel() {
        JPanel console = new JPanel();

        JLabel instructions = new JLabel("Server console, with clear button", JLabel.CENTER);
        console.add(instructions);

        console.setPreferredSize(new Dimension(600, 150));
        return console;
    }
}
