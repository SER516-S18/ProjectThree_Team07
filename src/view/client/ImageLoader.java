package view.client;



import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

import util.ClientConstants;

/**
 * This class loads the facial images in the specified panel
 * 
 * @author raam
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
		    File pathToFile = new File(ClientConstants.IMG_PATH + path + ClientConstants.FILE_TYPE);
		    Image image = ImageIO.read(pathToFile);
		    return image;
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
    		
    		Image scaledUpperImage = getImage(upperImagePath).getScaledInstance(320, 240, Image.SCALE_SMOOTH);
    		Image scaledLowerImage = getImage(lowerImagePath).getScaledInstance(320, 165, Image.SCALE_SMOOTH);
    		
    		JLabel upperImageLabel = new JLabel(new ImageIcon(scaledUpperImage));
    		JLabel lowerImageLabel = new JLabel(new ImageIcon(scaledLowerImage));
    		
    		JPanel tempPanel = new JPanel( new FlowLayout(FlowLayout.LEFT,0,0));
    		tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.Y_AXIS));
    		tempPanel.setMaximumSize(new Dimension(600, 200));
    		tempPanel.add(upperImageLabel);
    		tempPanel.add(lowerImageLabel);
    		facePanel.removeAll();
    		facePanel.add(tempPanel);
    		
    }
}
