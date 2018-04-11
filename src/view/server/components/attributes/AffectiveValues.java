package view.server.components.attributes;

import javax.swing.*;

/** @author Team 7 View for Affective values */
public class AffectiveValues {

  /**
   * Affective Values panel
   *
   * @return JPanel affectiveValuesPanel
   */
  public static JPanel getPanel() {
    JPanel affectiveValuesPanel = new JPanel();

    JLabel instructions = new JLabel("Counters to set the affective values", JLabel.CENTER);
    affectiveValuesPanel.add(instructions);

    return affectiveValuesPanel;
  }
}
