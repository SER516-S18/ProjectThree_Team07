package controller.server;

import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JSpinner;

import network.model.Status;
import network.server.Server;
import view.server.components.attributes.AttributeContainer;

/**
 * Class to hand message sending via network objects
 * @author raam
 *
 */
public class MessageSender {

	/**
	 * gets status object from server and sends to the client 
	 *
	 */
	public static Status getStatus() {
		Status status = Status.getInstance();

		// Getting values from Server UI
		JComboBox eyeCombo = AttributeContainer.getEyeCombo();

		JComboBox uperFaceCombo = AttributeContainer.getUpperFaceCombo();
		JSpinner uperFaceSpinner = AttributeContainer.getUpperFaceSpinner();

		JComboBox lowerFaceCombo = AttributeContainer.getLowerFaceCombo();
		JSpinner lowerFaceSpinner = AttributeContainer.getLowerFaceSpinner();

		JSpinner frustrationSpinner = AttributeContainer.getFrustrationSpinner();
		JSpinner engagementSpinner = AttributeContainer.getEngagementSpinner();
		JSpinner longTermSpinner = AttributeContainer.getLongTermSpinner();
		JSpinner shortTermSpinner = AttributeContainer.getShortTermSpinner();
		JSpinner meditationSpinner = AttributeContainer.getMeditationSpinner();

		HashMap<String,Double> eyeMap = new HashMap<String,Double>();
		HashMap<String,Double> uperFaceMap = new HashMap<String,Double>();
		HashMap<String,Double> lowerFaceMap = new HashMap<String,Double>();

		// Adding value as 1 in selected eye expression - boolean values
		String eyeSelection = eyeCombo.getSelectedItem().toString();
		setFacialCombos(eyeSelection);

		String uperFaceSelection = uperFaceCombo.getSelectedItem().toString();
		double uperFaceValue = (Double) uperFaceSpinner.getValue();
		uperFaceMap.put(uperFaceSelection, uperFaceValue);

		String lowerFaceSelection = uperFaceCombo.getSelectedItem().toString();
		double lowerFaceValue = (Double) uperFaceSpinner.getValue();
		uperFaceMap.put(uperFaceSelection, uperFaceValue);

		status.setFrustration((Double)frustrationSpinner.getValue());
		status.setMediation((Double)meditationSpinner.getValue());
		status.setExcitementLongTerm((Double)longTermSpinner.getValue());
		System.out.println("data"+"=================="+shortTermSpinner.getValue());
		status.setExcitementShortTerm((Double)shortTermSpinner.getValue());
		status.setEngagementBoredom((Double)engagementSpinner.getValue());

		status.setActivatedEye(AttributeContainer.getActivateStatus());

		return status;
	}

	private static void setFacialCombos(String eyeSelection) {
		Status status = Status.getInstance();
		clearFacialCombos();
		switch(eyeSelection){
			case "Blink":
				status.setBlink(true);
				break;
			case "Looking Left":
				status.setLookingLeft(true);
				break;
			case "Looking Right":
				status.setLookingRight(true);
				break;
			case "Looking Up" :
				status.setLookingUp(true);
				break;
			case "Looking Down":
				status.setLookingDown(true);
				break;
			case "Right Wink":
				status.setRightWink(true);
				break;
			case "Left Wink":
				status.setLeftWink(true);
				break;
		}
	}

	private static void clearFacialCombos() {
		Status status = Status.getInstance();
		status.setBlink(false);
		status.setLeftWink(false);
		status.setRightWink(false);
		status.setLookingDown(false);
		status.setLookingUp(false);
		status.setLookingLeft(false);
		status.setLookingRight(false);
	}

	public static void sendData() {
		Server.getInstance().sendStatus(getStatus());
	}
}