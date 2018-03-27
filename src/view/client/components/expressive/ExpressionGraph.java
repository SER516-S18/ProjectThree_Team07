package view.client.components.expressive;

import javax.swing.*;

public class ExpressionGraph {

    public static JPanel getPanel() {
        JPanel expressionData = new JPanel();

        JLabel instructions = new JLabel("Expression data graphed", JLabel.CENTER);
        expressionData.add(instructions);

        return expressionData;
    }
}
