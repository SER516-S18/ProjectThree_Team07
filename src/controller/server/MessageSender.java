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
	private static Server server = null;
	
	private static Server getServer() {
		if (server == null) {
			server = new Server();
		}
		return server;
	}
	
	/**
	 * 
	 * gets status object from server and sends to the client 
	 * 
	 */
	public static Status getStatus()
	{
		System.out.println("In getStatus");
		Status stat = new Status();

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
		eyeMap.put(eyeSelection, 1.0);

		String uperFaceSelection = uperFaceCombo.getSelectedItem().toString();
		double uperFaceValue = (Double) uperFaceSpinner.getValue();
		uperFaceMap.put(uperFaceSelection, uperFaceValue);

		String lowerFaceSelection = uperFaceCombo.getSelectedItem().toString();
		double lowerFaceValue = (Double) uperFaceSpinner.getValue();
		uperFaceMap.put(uperFaceSelection, uperFaceValue);

		// Setting status object
		stat.setBlink(eyeMap.get("blink"));
		stat.setLeftWink(eyeMap.get("leftWink"));
		stat.setRightWink(eyeMap.get("rightWink"));
		stat.setLookingDown(eyeMap.get("lookingDown"));
		stat.setLookingUp(eyeMap.get("lookingUp"));
		stat.setRightWink(eyeMap.get("rightWink"));
		stat.setLeftWink(eyeMap.get("leftWink"));

		stat.setEyebrowRaise(uperFaceMap.get("RaisedEyebrow"));
		stat.setEyesOpen(uperFaceMap.get("EyesOpen"));

		stat.setClench(lowerFaceMap.get("Clench"));
		stat.setSmile(lowerFaceMap.get("Smile"));

		stat.setFrustration((Double)frustrationSpinner.getValue());
		stat.setMediation((Double)meditationSpinner.getValue());
		stat.setExcitmentLongTerm((Double)longTermSpinner.getValue());
		stat.setExcitementShortTerm((Double)shortTermSpinner.getValue());
		stat.setEngagementBoredom((Double)engagementSpinner.getValue());

		stat.setAvtivateEye(AttributeContainer.getActivateStatus());

		return stat;
	}
	public static void sendData() {
		getServer().sendStatus(getStatus());
	}
	
}
