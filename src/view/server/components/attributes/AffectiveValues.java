package view.server.components.attributes;

import javax.swing.*;

public class AffectiveValues {

    public static JPanel getPanel() {
        JPanel affectiveValues = new JPanel();

        JLabel instructions = new JLabel("Counters to set the affective values", JLabel.CENTER);
        affectiveValues.add(instructions);

        return affectiveValues;
    }
}
