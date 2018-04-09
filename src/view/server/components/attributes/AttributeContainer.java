package view.server.components.attributes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeListener;

import controller.server.MessageTimer;

import javax.swing.event.ChangeEvent;

public class AttributeContainer {
	private static JTextField textFieldTime = null;
	private static JComboBox comboBoxEye = null;
	private static JComboBox upperFaceCombo1 = null;
	private static JSpinner spinnerUpperFace = null;
	private static JComboBox lowerFaceCombo1 = null;
	private static JSpinner spinnerLowerFace = null;
	private static JSpinner spinnerExcitement = null;
	private static JSpinner spinnerEngagement = null;
	private static JSpinner spinnerLongTerm = null;
	private static JSpinner spinnerFrustration = null;
	private static JSpinner spinnerShortTerm = null; 
	private static JSpinner spinnerMeditation = null;
	private static boolean isActivateEye = false;

	public static boolean getActivateStatus()
	{
		return isActivateEye ;
	}
	public static void setTimeTextField(String time)
	{
		textFieldTime.setText(time);
		MessageTimer.getInstance().setTimer(Float.parseFloat(time));
	}
	
	public static float getTimeTextField() {
		return Float.parseFloat(textFieldTime.getText());
	}
	
	public static JComboBox getEyeCombo() {
		return comboBoxEye;
	}

	public static JComboBox getUpperFaceCombo() {
		return upperFaceCombo1;
	}

	public static JComboBox getLowerFaceCombo() {
		return lowerFaceCombo1;
	}


	public static JSpinner getUpperFaceSpinner() {
		return spinnerUpperFace;
	}

	public static JSpinner getLowerFaceSpinner() {
		return spinnerLowerFace;
	}

	public static JSpinner getExcitementSpinner() {
		return spinnerExcitement;
	}

	public static JSpinner getEngagementSpinner() {
		return spinnerEngagement;
	}

	public static JSpinner getLongTermSpinner() {
		return spinnerLongTerm;
	}

	public static JSpinner getFrustrationSpinner() {
		return spinnerFrustration;
	}

	public static JSpinner getShortTermSpinner() {
		return spinnerShortTerm;
	}

	public static JSpinner getMeditationSpinner() {
		return spinnerMeditation;
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	 @SuppressWarnings("unchecked")
	 public static JPanel getPanel() {
		 JPanel attributeContainer = new JPanel();


		 attributeContainer.setPreferredSize(new Dimension(600, 502));
		 attributeContainer.setLayout(null);

		 JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		 tabbedPane.setBounds(0, 0, 698, 502);
		 attributeContainer.add(tabbedPane);

		 JPanel detectionTab = new JPanel();
		 detectionTab.setBackground(Color.WHITE);
		 detectionTab.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 tabbedPane.addTab("Detection", null, detectionTab, null);
		 detectionTab.setLayout(null);

		 JLabel detectionTopLabel = new JLabel("Emo State ");
		 detectionTopLabel.setBounds(15, 13, 104, 32);
		 detectionTopLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 detectionTab.add(detectionTopLabel);

		 JLabel labelTime = new JLabel("Time:");
		 labelTime.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 labelTime.setBounds(15, 61, 69, 20);
		 detectionTab.add(labelTime);

		 textFieldTime = new JTextField();
		 textFieldTime.setBounds(66, 58, 146, 26);
		 detectionTab.add(textFieldTime);
		 textFieldTime.setColumns(10);

		 JLabel labelSec = new JLabel("sec");
		 labelSec.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 labelSec.setBounds(224, 61, 69, 20);
		 detectionTab.add(labelSec); 

		 JLabel labelUpperFace = new JLabel("Upper Face:");
		 labelUpperFace.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 labelUpperFace.setBounds(25, 252, 197, 20);
		 detectionTab.add(labelUpperFace);

		 upperFaceCombo1 = new JComboBox();
		 upperFaceCombo1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 upperFaceCombo1.setModel(new DefaultComboBoxModel(new String[] {"RaisedEyebrow", "EyesOpen"}));
		 upperFaceCombo1.setBounds(25, 288, 173, 26);
		 upperFaceCombo1.setBackground(Color.WHITE);
		 detectionTab.add(upperFaceCombo1);

		 spinnerUpperFace = new JSpinner();
		 spinnerUpperFace.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
		 JSpinner.NumberEditor editor0 = new JSpinner.NumberEditor(spinnerUpperFace);
		 spinnerUpperFace.setEditor(editor0);
		 spinnerUpperFace.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 spinnerUpperFace.setBounds(218, 288, 62, 26);
		 detectionTab.add(spinnerUpperFace);

		 JLabel labelLowerFace = new JLabel("Lower Face:");
		 labelLowerFace.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 labelLowerFace.setBounds(323, 252, 127, 20);
		 detectionTab.add(labelLowerFace);

		 lowerFaceCombo1 = new JComboBox();
		 lowerFaceCombo1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 lowerFaceCombo1.setModel(new DefaultComboBoxModel(new String[] {"Smile", "Clench"}));
		 lowerFaceCombo1.setBounds(324, 288, 155, 27);
		 detectionTab.add(lowerFaceCombo1);

		 spinnerLowerFace = new JSpinner();
		 spinnerLowerFace.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
		 JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinnerLowerFace);
		 spinnerLowerFace.setEditor(editor);
		 spinnerLowerFace.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 spinnerLowerFace.setBounds(496, 288, 62, 26);
		 detectionTab.add(spinnerLowerFace);

		 JLabel labelEye = new JLabel("Eye");
		 labelEye.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 labelEye.setBounds(22, 330, 69, 20);
		 detectionTab.add(labelEye);

		 comboBoxEye = new JComboBox();
		 comboBoxEye.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 comboBoxEye.setModel(new DefaultComboBoxModel(new String[] {"Blink", "Looking Left", "Looking Right", "Looking Up", "Looking Down", "Right Wink", "Left Wink"}));
		 comboBoxEye.setBounds(25, 358, 173, 29);
		 detectionTab.add(comboBoxEye);

		 JCheckBox detectionCheckBox = new JCheckBox("Auto Reset");
		 detectionCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 detectionCheckBox.setBounds(364, 358, 183, 29);
		 detectionTab.add(detectionCheckBox);

		 JLabel labelAffective = new JLabel("Affective");
		 labelAffective.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 labelAffective.setBounds(25, 100, 76, 20);
		 detectionTab.add(labelAffective);

		 JLabel lblExcitement = new JLabel("Excitement");
		 lblExcitement.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 lblExcitement.setBounds(106, 100, 96, 20);
		 detectionTab.add(lblExcitement);

		 JLabel lblEngagementboredom = new JLabel("Engagement/Boredom");
		 lblEngagementboredom.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 lblEngagementboredom.setBounds(106, 136, 174, 20);
		 detectionTab.add(lblEngagementboredom);

		 spinnerExcitement = new JSpinner();
		 spinnerExcitement.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
		 JSpinner.NumberEditor editor1 = new JSpinner.NumberEditor(spinnerExcitement);
		 spinnerExcitement.setEditor(editor1);
		 spinnerExcitement.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 spinnerExcitement.setBounds(291, 97, 59, 26);
		 detectionTab.add(spinnerExcitement);

		 spinnerEngagement = new JSpinner();
		 spinnerEngagement.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
		 JSpinner.NumberEditor editor2 = new JSpinner.NumberEditor(spinnerEngagement);
		 spinnerEngagement.setEditor(editor2);
		 spinnerEngagement.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 spinnerEngagement.setBounds(291, 133, 59, 26);
		 detectionTab.add(spinnerEngagement);


		 JLabel lblLongTerm = new JLabel("ExcitementLongTerm");
		 lblLongTerm.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		 lblLongTerm.setBounds(364, 100, 146, 20);
		 detectionTab.add(lblLongTerm);

		 spinnerLongTerm = new JSpinner();
		 spinnerLongTerm.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
		 JSpinner.NumberEditor editor3 = new JSpinner.NumberEditor(spinnerLongTerm);
		 spinnerLongTerm.setEditor(editor3);
		 spinnerLongTerm.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 spinnerLongTerm.setBounds(499, 97, 59, 26);
		 detectionTab.add(spinnerLongTerm);

		 JButton btnActivate = new JButton("Activate");
		 btnActivate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 btnActivate.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 isActivateEye = true;
			 }
		 });
		 btnActivate.setBounds(225, 358, 115, 29);
		 detectionTab.add(btnActivate);

		 JLabel lblNewLabel = new JLabel("Frustration");
		 lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 lblNewLabel.setBounds(364, 136, 86, 20);
		 detectionTab.add(lblNewLabel);

		 spinnerFrustration = new JSpinner();
		 spinnerFrustration.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 spinnerFrustration.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
		 JSpinner.NumberEditor editor4 = new JSpinner.NumberEditor(spinnerFrustration);
		 spinnerFrustration.setEditor(editor4);
		 spinnerFrustration.setBounds(499, 133, 59, 26);
		 detectionTab.add(spinnerFrustration);

		 JLabel lblShortTerm = new JLabel("Excitement Short Term");
		 lblShortTerm.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 lblShortTerm.setBounds(106, 178, 174, 20);
		 detectionTab.add(lblShortTerm);

		 spinnerShortTerm = new JSpinner();
		 spinnerShortTerm.setBounds(291, 175, 59, 26);
		 spinnerShortTerm.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 spinnerShortTerm.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
		 JSpinner.NumberEditor editor5 = new JSpinner.NumberEditor(spinnerShortTerm);
		 spinnerShortTerm.setEditor(editor5);
		 detectionTab.add(spinnerShortTerm);
		 tabbedPane.setEnabledAt(0, true);

		 JLabel lblMeditation = new JLabel("Meditation");
		 lblMeditation.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 lblMeditation.setBounds(364, 178, 174, 20);
		 detectionTab.add(lblMeditation);

		 spinnerMeditation = new JSpinner();
		 spinnerMeditation.setBounds(499, 175, 59, 26);
		 spinnerMeditation.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		 spinnerMeditation.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
		 JSpinner.NumberEditor editor6 = new JSpinner.NumberEditor(spinnerMeditation);
		 spinnerMeditation.setEditor(editor6);
		 detectionTab.add(spinnerMeditation);
		 tabbedPane.setEnabledAt(0, true);

		 return attributeContainer;
	 }
}
