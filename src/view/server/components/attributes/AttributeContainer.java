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
	private static JComboBox upperFaceCombo = null;
	private static JSpinner spinnerUpperFace = null;
	private static JComboBox lowerFaceCombo = null;
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
		return upperFaceCombo;
	}

	public static JComboBox getLowerFaceCombo() {
		return lowerFaceCombo;
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


		attributeContainer.setPreferredSize(new Dimension(600, 360));
		attributeContainer.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1000, 360);
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

//		Affective Input Items
		JLabel labelAffective = new JLabel("Affective");
		labelAffective.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labelAffective.setBounds(15, 100, 76, 20);
		detectionTab.add(labelAffective);
//-----------
		JLabel lbMeditation = new JLabel("Meditation");
		lbMeditation.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbMeditation.setBounds(15, 130, 96, 20);
		detectionTab.add(lbMeditation);

		spinnerMeditation = new JSpinner();
		spinnerMeditation.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
		JSpinner.NumberEditor meditationSpinnerEditor = new JSpinner.NumberEditor(spinnerMeditation);
		spinnerMeditation.setEditor(meditationSpinnerEditor);
		spinnerMeditation.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		spinnerMeditation.setBounds(320, 130, 59, 26);
		detectionTab.add(spinnerMeditation);
//---------
		JLabel lblEngagementboredom = new JLabel("Engagement / Boredom");
		lblEngagementboredom.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEngagementboredom.setBounds(15, 160, 174, 20);
		detectionTab.add(lblEngagementboredom);

		spinnerEngagement = new JSpinner();
		spinnerEngagement.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
		JSpinner.NumberEditor editor2 = new JSpinner.NumberEditor(spinnerEngagement);
		spinnerEngagement.setEditor(editor2);
		spinnerEngagement.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		spinnerEngagement.setBounds(320, 160, 59, 26);
		detectionTab.add(spinnerEngagement);
//--------
		JLabel lblShortTerm = new JLabel("Excitement Short Term");
		lblShortTerm.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblShortTerm.setBounds(15, 190, 174, 20);
		detectionTab.add(lblShortTerm);

		spinnerShortTerm = new JSpinner();
		spinnerShortTerm.setBounds(320, 190, 59, 26);
		spinnerShortTerm.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		spinnerShortTerm.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
		JSpinner.NumberEditor editor5 = new JSpinner.NumberEditor(spinnerShortTerm);
		spinnerShortTerm.setEditor(editor5);
		detectionTab.add(spinnerShortTerm);
		tabbedPane.setEnabledAt(0, true);
//------------

		JLabel lblFrustration = new JLabel("Frustration");
		lblFrustration.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblFrustration.setBounds(15, 220, 86, 20);
		detectionTab.add(lblFrustration);

		spinnerFrustration = new JSpinner();
		spinnerFrustration.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		spinnerFrustration.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
		JSpinner.NumberEditor editor4 = new JSpinner.NumberEditor(spinnerFrustration);
		spinnerFrustration.setEditor(editor4);
		spinnerFrustration.setBounds(320, 220, 59, 26);
		detectionTab.add(spinnerFrustration);

//-----------

		JLabel lblLongTerm = new JLabel("Excitement Long Term");
		lblLongTerm.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblLongTerm.setBounds(15, 250, 260, 20);
		detectionTab.add(lblLongTerm);

		spinnerLongTerm = new JSpinner();
		spinnerLongTerm.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
		JSpinner.NumberEditor editor3 = new JSpinner.NumberEditor(spinnerLongTerm);
		spinnerLongTerm.setEditor(editor3);
		spinnerLongTerm.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		spinnerLongTerm.setBounds(320, 250, 59, 26);
		detectionTab.add(spinnerLongTerm);

//------------------
//	Expressive Input Items
		JLabel labelExpressive = new JLabel("Expressive");
		labelExpressive.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labelExpressive.setBounds(430, 100, 100, 20);
		detectionTab.add(labelExpressive);

//		--------

		JLabel labelUpperFace = new JLabel("Upper Face:");
		labelUpperFace.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labelUpperFace.setBounds(430, 130, 197, 20);
		detectionTab.add(labelUpperFace);

		upperFaceCombo = new JComboBox();
		upperFaceCombo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		upperFaceCombo.setModel(new DefaultComboBoxModel(new String[] {"RaisedEyebrow", "EyesOpen"}));
		upperFaceCombo.setBounds(560, 130, 173, 26);
		upperFaceCombo.setBackground(Color.WHITE);
		detectionTab.add(upperFaceCombo);

		spinnerUpperFace = new JSpinner();
		spinnerUpperFace.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
		JSpinner.NumberEditor editor0 = new JSpinner.NumberEditor(spinnerUpperFace);
		spinnerUpperFace.setEditor(editor0);
		spinnerUpperFace.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		spinnerUpperFace.setBounds(740, 130, 62, 26);
		detectionTab.add(spinnerUpperFace);

//---------
		JLabel labelLowerFace = new JLabel("Lower Face:");
		labelLowerFace.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labelLowerFace.setBounds(430, 160, 127, 20);
		detectionTab.add(labelLowerFace);

		lowerFaceCombo = new JComboBox();
		lowerFaceCombo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lowerFaceCombo.setModel(new DefaultComboBoxModel(new String[] {"Smile", "Clench"}));
		lowerFaceCombo.setBounds(560, 160, 173, 27);
		detectionTab.add(lowerFaceCombo);

		spinnerLowerFace = new JSpinner();
		spinnerLowerFace.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinnerLowerFace);
		spinnerLowerFace.setEditor(editor);
		spinnerLowerFace.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		spinnerLowerFace.setBounds(740, 160, 62, 26);
		detectionTab.add(spinnerLowerFace);
//		---------

		JLabel labelEye = new JLabel("Eye");
		labelEye.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labelEye.setBounds(430, 190, 69, 20);
		detectionTab.add(labelEye);

		comboBoxEye = new JComboBox();
		comboBoxEye.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBoxEye.setModel(new DefaultComboBoxModel(new String[] {"Blink", "Looking Left", "Looking Right", "Looking Up", "Looking Down", "Right Wink", "Left Wink"}));
		comboBoxEye.setBounds(560, 190, 173, 29);
		detectionTab.add(comboBoxEye);

		JButton btnActivate = new JButton("Activate");
		btnActivate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnActivate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isActivateEye = true;
			}
		});
		btnActivate.setBounds(740, 190, 115, 29);
		detectionTab.add(btnActivate);

		JCheckBox detectionAutoResetCheckBox = new JCheckBox("Auto Reset");
		detectionAutoResetCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		detectionAutoResetCheckBox.setBounds(862, 190, 183, 29);
		detectionTab.add(detectionAutoResetCheckBox);

//		-----------

		 return attributeContainer;
	 }
}
