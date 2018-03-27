package view.client.components.affective;

import javax.swing.*;

public class AffectiveGraph {

    public static JPanel getPanel() {
        JPanel affectiveGraph = new JPanel();

        JLabel instructions = new JLabel("Graph displaying affective data", JLabel.CENTER);
        affectiveGraph.add(instructions);

        return affectiveGraph;
    }
}
