package view.client.components.affective;

import javax.swing.*;
import java.awt.*;

public class AffectiveTab {

    public static JPanel getPanel() {
        JPanel affectiveTab = new JPanel();
        affectiveTab.add(AffectiveTimeSeriesGraph.getinstance().getPanel());

        return affectiveTab;
    }
}
