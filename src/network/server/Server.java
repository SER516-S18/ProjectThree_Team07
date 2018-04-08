package network.server;

import network.model.Status;
import view.server.components.attributes.AttributeContainer;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.websocket.DeploymentException;
import javax.websocket.EncodeException;
import javax.websocket.Session;

import java.io.IOException;
import java.util.HashMap;

import static util.NetworkConstants.PORT;
import static util.NetworkConstants.HOST;
import static util.NetworkConstants.ROOT_PATH;

public class Server {

	private org.glassfish.tyrus.server.Server server;

	public Server() {
		server = new org.glassfish.tyrus.server.Server(HOST, PORT, "/" + ROOT_PATH, ServerEndpoint.class);
	}

	public void start() {
		try {
			server.start();
		} catch (DeploymentException e) {
			e.printStackTrace();
		}
	}

	public Status sendStatus() {
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

		
		for (Session peer : ServerEndpoint.peers) {
			try {
				peer.getBasicRemote().sendObject(stat);
			} catch (IOException | EncodeException e) {
				e.printStackTrace();
			}
		}
		
		return stat;
		// Original Method
		//		public void sendStatus(Status status) {
		//		status.setRightWink(0.234);
		//		status.setBlink(0.123);
		//		status.setClench(0.2343);
		//		status.setLookingRight(0.2234);
		//		status.setEyebrowRaise(0.4444);
		//		status.setEyesOpen(0.343);
		//		status.setFrustration(0.4342);
		//		status.setLeftWink(0.23421);
		//
		//		status.setLookingDown(0.23411);
		//		status.setLookingLeft(0.551);
		//		status.setLookingUp(0.234321);
		//		status.setSmile(0.1232);
		//
		//		status.setExcitmentLongTerm(0.2343);
		//		status.setExcitementShortTerm(0.234);
		//
		//		status.setMediation(0.34343);
		//		status.setEngagementBoredom(0.2343);
		//
		//		for (Session peer : ServerEndpoint.peers) {
		//			try {
		//				peer.getBasicRemote().sendObject(status);
		//			} catch (IOException | EncodeException e) {
		//				e.printStackTrace();
		//			}
		//		}
		//	}
	}


}
