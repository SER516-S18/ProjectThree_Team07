package view.server.components.attributes;

import javax.swing.*;

public class ExpressionValues {

    public static JPanel getPanel() {
        JPanel expressionValues = new JPanel();

        JLabel instructions = new JLabel("Counters to set the expression values", JLabel.CENTER);
        expressionValues.add(instructions);

        return expressionValues;
    }
}
