package view.client.components.affective;

import javax.swing.*;
import java.awt.*;

/**
 * @author Team 7
 * Affective Tab panel
 * */
public class AffectiveTab {

  /**
   * Affective panel
   * @return JPanel
   */
  public static JPanel getPanel() {
    JPanel affectiveTabPanel = new JPanel();
    affectiveTabPanel.add(AffectiveTimeSeriesGraph.getinstance().getPanel());

    return affectiveTabPanel;
  }
}
