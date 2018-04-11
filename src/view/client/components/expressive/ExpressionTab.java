package view.client.components.expressive;

import javax.swing.*;

public class ExpressionTab {

    public static JPanel getFacePanel() {
        JPanel expressionData = new JPanel();
        expressionData.add(FacialExpressions.getPanel());
        return expressionData;
    }

    public static JPanel getExpressivePanel(){
        JPanel expressionData = new JPanel();
        ExpressiveTimeSeriesGraph expressiveTimeSeriesGraph = ExpressiveTimeSeriesGraph.getinstance();
        expressionData.add(expressiveTimeSeriesGraph.getPanel());
        return expressionData;
    }
}
