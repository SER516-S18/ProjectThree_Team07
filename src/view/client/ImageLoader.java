package view.client;

import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

import util.ClientConstants;
import view.client.components.expressive.FacialExpressions;

/**
 * This class loads the facial images in the specified panel
 *
 * @author Team 7
 */
public class ImageLoader {

  /**
   * Read image data from the specified path
   *
   * @param path - the path from which image has to be loaded
   * @return Loaded Image object
   */
  public static Image getImage(String path) {
    try {
      File pathToFile = new File(ClientConstants.IMG_PATH + path);
      return ImageIO.read(pathToFile);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    return null;
  }

  /**
   * Load images path give into the panel sent
   *
   * @param facePanel - the panel in which image has to be loaded
   * @param upperImagePath - the image path of the upper image
   * @param lowerImagePath - the image path of the lower image
   */
  public static void loadImage(JPanel facePanel, String upperImagePath, String lowerImagePath) {

    Image scaledUpperImage = null;
    Image scaledLowerImage = null;

    facePanel.removeAll();
    if (FacialExpressions.getFileTypeCombo()
        .getSelectedItem()
        .toString()
        .equals(ClientConstants.EMOJI_TYPE)) {
      scaledUpperImage =
          getImage(upperImagePath + ClientConstants.FILE_TYPE_PNG)
              .getScaledInstance(
                  ClientConstants.PNG_WIDTH, ClientConstants.PNG_UPPER_HEIGHT, Image.SCALE_SMOOTH);
      scaledLowerImage =
          getImage(lowerImagePath + ClientConstants.FILE_TYPE_PNG)
              .getScaledInstance(
                  ClientConstants.PNG_WIDTH, ClientConstants.PNG_LOWER_HEIGHT, Image.SCALE_SMOOTH);
      facePanel.setBackground(new Color(255, 255, 255));
    } else {
      scaledUpperImage =
          getImage(upperImagePath + ClientConstants.FILE_TYPE_JPEG)
              .getScaledInstance(
                  ClientConstants.JPEG_WIDTH,
                  ClientConstants.JPEG_UPPER_HEIGHT,
                  Image.SCALE_SMOOTH);
      scaledLowerImage =
          getImage(lowerImagePath + ClientConstants.FILE_TYPE_JPEG)
              .getScaledInstance(
                  ClientConstants.JPEG_WIDTH,
                  ClientConstants.JPEG_LOWER_HEIGHT,
                  Image.SCALE_SMOOTH);
      facePanel.setBackground(new Color(177, 177, 177));
    }

    JLabel upperImageLabel = new JLabel(new ImageIcon(scaledUpperImage));
    JLabel lowerImageLabel = new JLabel(new ImageIcon(scaledLowerImage));

    JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
    imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
    imagePanel.setMaximumSize(new Dimension(600, 200));
    imagePanel.add(upperImageLabel);
    imagePanel.add(lowerImageLabel);
    facePanel.add(FacialExpressions.getFileTypeCombo());
    facePanel.add(imagePanel);
    facePanel.validate();
  }
}
