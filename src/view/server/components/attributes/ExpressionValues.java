package view.server.components.attributes;

import javax.swing.*;

/** @author Team 7 Expression values panel */
public class ExpressionValues {

  /**
   * Expression Values Panel
   *
   * @return JPanel expressionValuesPanel
   */
  public static JPanel getPanel() {
    JPanel expressionValuesPanel = new JPanel();

    JLabel instructions = new JLabel("Counters to set the expression values", JLabel.CENTER);
    expressionValuesPanel.add(instructions);

    return expressionValuesPanel;
  }
}
