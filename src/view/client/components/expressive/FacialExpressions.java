package view.client.components.expressive;

import javax.swing.*;

public class FacialExpressions {

    public static JPanel getPanel() {
        JPanel facialExpressions = new JPanel();

        JLabel instructions = new JLabel("Images displaying the current facial expression", JLabel.CENTER);
        facialExpressions.add(instructions);

        return facialExpressions;
    }
}
