package view.server.components.attributes;

import javax.swing.*;
import java.awt.*;

public class AttributeContainer {

    public static JPanel getPanel() {
        JPanel attributeContainer = new JPanel();

        attributeContainer.add(AffectiveValues.getPanel());
        attributeContainer.add(ExpressionValues.getPanel());

        attributeContainer.setPreferredSize(new Dimension(600, 600));

        return attributeContainer;
    }
}
