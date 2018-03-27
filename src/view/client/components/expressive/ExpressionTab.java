package view.client.components.expressive;

import javax.swing.*;

public class ExpressionTab {

    public static JPanel getPanel() {
        JPanel expressionData = new JPanel();

        expressionData.add(FacialExpressions.getPanel());
        expressionData.add(ExpressionGraph.getPanel());

        return expressionData;
    }
}
