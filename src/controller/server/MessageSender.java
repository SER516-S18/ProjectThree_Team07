package controller.server;

import network.model.Status;
import network.server.Server;
import util.ServerConstants;
import view.server.components.attributes.AttributeContainer;

/**
 * Class to hand message sending via network objects
 * @author raam
 *
 */
public class MessageSender {

	static Status status = Status.getInstance();

	public static void constructStatus() {
		clearEyeBrowValue();
		clearLowerFaceValues();
		clearEyeActionValues();
		clearEmotionalValues();
		
		setEyeBrowValue();
		setLowerFaceValues();
		setEyeActionValues();
		setEmotionalValues();
	}

	private static void clearLowerFaceValues() {
		status.setSmile(0);
		status.setClench(0);
		status.setSmirkLeft(0);
		status.setSmirkRight(0);
		status.setLaugh(0);
	}
	
	private static void clearEyeBrowValue() {
		status.setEyebrowRaise(0);
		status.setEyebrowFurrow(0);
	}
	
	private static void clearEyeActionValues() {
		status.setBlink(false);
		status.setLeftWink(false);
		status.setRightWink(false);
		status.setLookingLeft(false);
		status.setLookingRight(false);
	}
	
	
	private static void clearEmotionalValues() {
		// TODO Auto-generated method stub	
	}

	
	private static void setEyeBrowValue() {
		String eyeBrow = AttributeContainer.getUpperFaceCombo().getSelectedItem().toString();
		Double value = (Double) AttributeContainer.getUpperFaceSpinner().getValue();
		
		switch (eyeBrow) {
			case ServerConstants.EYEBROW_RAISE : 
				status.setEyebrowRaise(value);
				break;
			case ServerConstants.EYEBROW_FURROW:
				status.setEyebrowFurrow(value);
				break;
			default :
				break;
		}
	
	}
	
	private static void setLowerFaceValues() {
		String lowerFace = AttributeContainer.getLowerFaceCombo().getSelectedItem().toString();
		Double value = (Double) AttributeContainer.getLowerFaceSpinner().getValue();
		
		switch (lowerFace) {
			case ServerConstants.SMILE : 
				status.setSmile(value);
				break;
			case ServerConstants.CLENCH:
				status.setClench(value);
				break;
			case ServerConstants.SMIRK_LEFT:
				status.setSmirkLeft(value);
				break;
			case ServerConstants.SMIRK_RIGHT:
				status.setSmirkRight(value);
				break;
			case ServerConstants.LAUGH:
				status.setLaugh(value);
				break;
			default :
				break;
		}
	}
	
	private static void setEyeActionValues() {
		String eyeAction = AttributeContainer.getEyeCombo().getSelectedItem().toString();
		
		switch (eyeAction) {
			case ServerConstants.BLINK : 
				status.setBlink(true);
				break;
			case ServerConstants.LEFT_WINK:
				status.setLeftWink(true);
				break;
			case ServerConstants.RIGHT_WINK:
				status.setRightWink(true);
				break;
			case ServerConstants.LOOKING_LEFT:
				status.setLookingLeft(true);
				break;
			case ServerConstants.LOOKING_RIGHT:
				status.setLookingRight(true);
				break;
			default :
				break;
		}
	}
	
	private static void setEmotionalValues() {
		// TODO Auto-generated method stub
		
	}
	
	public static void sendData() {
		constructStatus();
		Server.getInstance().sendStatus(status);
	}
}