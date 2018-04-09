package view.client.components.expressive;

import java.awt.Color;

import javax.swing.*;

import controller.client.FacialExpressionSolver;
import view.client.ImageLoader;

/**
 * Panel to hold facial expressions
 * @author raam
 *
 */
public class FacialExpressions {

	static JPanel facialExpressions = null;
	
	/**
	 * Constructs and return the facial expression panel
	 * 
	 * @return the panel holding facial expression
	 */
    public static JPanel getPanel() {
        if (facialExpressions == null) {
        		facialExpressions = new JPanel();
        		facialExpressions.setBackground(new Color(177, 177, 177));
        		ImageLoader.loadImage(facialExpressions,
        			FacialExpressionSolver.UpperFace.NORMAL.getFileName(),
                	FacialExpressionSolver.LowerFace.NORMAL.getFileName());
        }
        
        return facialExpressions;
    }
}
