package controller.server;

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
	private static Server server = null;

	private static Server getServer() {
		if (server == null) {
			server = new Server();
		}
		return server;
	}

	/**
	 *
	 * get status object from server and sends to the client
	 *
	 */
	public static Status getStatus() {
		System.out.println("In getStatus");
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

		// Adding value as 1 in selected eye expression - boolean values
		String eyeSelection = eyeCombo.getSelectedItem().toString();

		String uperFaceSelection = uperFaceCombo.getSelectedItem().toString();
		double uperFaceValue = (Double) uperFaceSpinner.getValue();

		String lowerFaceSelection = uperFaceCombo.getSelectedItem().toString();
		double lowerFaceValue = (Double) uperFaceSpinner.getValue();

		//clearFacialCombos();
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

		System.out.println(status.getLookingDown());


		status.setFrustration((Double)frustrationSpinner.getValue());
		status.setMediation((Double)meditationSpinner.getValue());
		status.setExcitementLongTerm((Double)longTermSpinner.getValue());
		status.setExcitementShortTerm((Double)shortTermSpinner.getValue());
		status.setEngagementBoredom((Double)engagementSpinner.getValue());

		status.setActivatedEye(AttributeContainer.getActivateStatus());

		return status;
	}

	public static void sendData() {
		getServer().sendStatus(getStatus());
	}

	private void clearFacialCombos() {
		Status status = Status.getInstance();
		status.setBlink(false);
		status.setLeftWink(false);
		status.setRightWink(false);
		status.setLookingDown(false);
		status.setLookingUp(false);
		status.setLookingLeft(false);
		status.setLookingRight(false);
	}

	private void setFacialCombos() {
		clearFacialCombos();
		JComboBox eyeCombo = AttributeContainer.getEyeCombo();
		Status status = Status.getInstance();

		String eyeSelection = eyeCombo.getSelectedItem().toString();

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
}