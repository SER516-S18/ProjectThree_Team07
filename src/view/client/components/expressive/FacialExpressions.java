package view.client.components.expressive;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import controller.client.FacialExpressionSolver;
import util.ClientConstants;
import view.client.ImageLoader;

/**
 * Panel to hold facial expressions
 *
 * @author Team 7
 */
public class FacialExpressions {

  static JPanel facialExpressions = null;
  static JComboBox<String> fileTypeCombo = null;

  /**
   * Constructs and return the facial expression panel
   *
   * @return the panel holding facial expression
   */
  public static JPanel getPanel() {
    if (facialExpressions == null) {
      constructFacePanel();
    }
    return facialExpressions;
  }

  public static JComboBox<String> getFileTypeCombo() {
    if (fileTypeCombo == null) {
      constructFileTypeCombo();
    }
    return fileTypeCombo;
  }

  public static void constructFileTypeCombo() {
    fileTypeCombo = new JComboBox<String>();
    fileTypeCombo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    fileTypeCombo.setModel(
        new DefaultComboBoxModel<String>(
            new String[] {ClientConstants.IMAGE_TYPE, ClientConstants.EMOJI_TYPE}));
  }

  public static void constructFacePanel() {
    facialExpressions = new JPanel();
    facialExpressions.setBackground(new Color(177, 177, 177));
    ImageLoader.loadImage(
        facialExpressions,
        FacialExpressionSolver.UpperFace.NORMAL.getFileName(),
        FacialExpressionSolver.LowerFace.NORMAL.getFileName());
  }
}
