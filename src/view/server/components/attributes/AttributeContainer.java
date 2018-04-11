package view.server.components.attributes;

import javax.swing.*;
import java.awt.*;

import controller.server.MessageTimer;
import util.ServerConstants;

/** @author Team 7 Attriute Container for Server */
public class AttributeContainer {
  private static JTextField textFieldTime = null;
  private static JComboBox comboBoxEye = null;
  private static JComboBox upperFaceCombo = null;
  private static JSpinner spinnerUpperFace = null;
  private static JComboBox lowerFaceCombo = null;
  private static JSpinner spinnerLowerFace = null;
  private static JSpinner spinnerExcitement = null;
  private static JSpinner spinnerEngagement = null;
  private static JSpinner spinnerRelaxation = null;
  private static JSpinner spinnerStress = null;
  private static JSpinner spinnerInterest = null;
  private static JSpinner spinnerFocus = null;
  private static JToggleButton btnActivate = null;
  private static JCheckBox detectionAutoResetCheckBox = null;
  private static JPanel attributeContainer = null;
  private static JPanel detectionTab = null;
  private static JTabbedPane tabbedPane = null;

  public static boolean getActivateStatus() {
    return btnActivate.isSelected();
  }

  public static boolean isAutoReset() {
    return detectionAutoResetCheckBox.isSelected();
  }

  public static void unSelectActivateButton() {
    btnActivate.setSelected(false);
  }

  public static void setTimeTextField(String time) {
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
    return spinnerExcitement;
  }

  public static JSpinner getRelaxationSpinner() {
    return spinnerRelaxation;
  }

  public static JSpinner getStressSpinner() {
    return spinnerStress;
  }

  public static JSpinner getInterestSpinner() {
    return spinnerInterest;
  }

  public static JSpinner getFocusSpinner() {
    return spinnerFocus;
  }

  @SuppressWarnings("unchecked")
  public static JPanel getPanel() {

    if (attributeContainer == null) {
      attributeContainer = new JPanel();
      constructAttributePanel();
    }
    return attributeContainer;
  }

  /** Construct attribute panel */
  public static void constructAttributePanel() {
    constructStatusPanel();
    constructAffectivePanel();
    constructExpressivePanel();
  }

  /** Construct Status Panel */
  public static void constructStatusPanel() {

    attributeContainer.setPreferredSize(new Dimension(600, 360));
    attributeContainer.setLayout(null);

    tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    tabbedPane.setBounds(0, 0, 1000, 355);
    attributeContainer.add(tabbedPane);

    detectionTab = new JPanel();
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
  }

  /** Construct Affective Panel */
  public static void constructAffectivePanel() {

    JLabel labelAffective = new JLabel("Affective");
    labelAffective.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    labelAffective.setBounds(15, 100, 76, 20);
    detectionTab.add(labelAffective);

    JLabel lbInterest = new JLabel(ServerConstants.INTEREST);
    lbInterest.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    lbInterest.setBounds(15, 130, 96, 20);
    detectionTab.add(lbInterest);

    spinnerInterest = new JSpinner();
    spinnerInterest.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1));
    JSpinner.NumberEditor meditationSpinnerEditor = new JSpinner.NumberEditor(spinnerInterest);
    spinnerInterest.setEditor(meditationSpinnerEditor);
    spinnerInterest.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    spinnerInterest.setBounds(320, 130, 59, 26);
    detectionTab.add(spinnerInterest);

    JLabel lblEngagement = new JLabel(ServerConstants.ENGAGEMENT);
    lblEngagement.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    lblEngagement.setBounds(15, 160, 174, 20);
    detectionTab.add(lblEngagement);

    spinnerEngagement = new JSpinner();
    spinnerEngagement.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1));
    JSpinner.NumberEditor editor2 = new JSpinner.NumberEditor(spinnerEngagement);
    spinnerEngagement.setEditor(editor2);
    spinnerEngagement.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    spinnerEngagement.setBounds(320, 160, 59, 26);
    detectionTab.add(spinnerEngagement);

    JLabel lblStress = new JLabel(ServerConstants.STRESS);
    lblStress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    lblStress.setBounds(15, 190, 174, 20);
    detectionTab.add(lblStress);

    spinnerStress = new JSpinner();
    spinnerStress.setBounds(320, 190, 59, 26);
    spinnerStress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    spinnerStress.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1));
    JSpinner.NumberEditor editor5 = new JSpinner.NumberEditor(spinnerStress);
    spinnerStress.setEditor(editor5);
    detectionTab.add(spinnerStress);
    tabbedPane.setEnabledAt(0, true);

    JLabel lblRelaxation = new JLabel(ServerConstants.RELAXATION);
    lblRelaxation.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    lblRelaxation.setBounds(15, 220, 86, 20);
    detectionTab.add(lblRelaxation);

    spinnerRelaxation = new JSpinner();
    spinnerRelaxation.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    spinnerRelaxation.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1));
    JSpinner.NumberEditor editor4 = new JSpinner.NumberEditor(spinnerRelaxation);
    spinnerRelaxation.setEditor(editor4);
    spinnerRelaxation.setBounds(320, 220, 59, 26);
    detectionTab.add(spinnerRelaxation);

    JLabel lblExcitement = new JLabel(ServerConstants.EXCITEMENT);
    lblExcitement.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    lblExcitement.setBounds(15, 250, 260, 20);
    detectionTab.add(lblExcitement);

    spinnerExcitement = new JSpinner();
    spinnerExcitement.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1));
    JSpinner.NumberEditor editor3 = new JSpinner.NumberEditor(spinnerExcitement);
    spinnerExcitement.setEditor(editor3);
    spinnerExcitement.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    spinnerExcitement.setBounds(320, 250, 59, 26);
    detectionTab.add(spinnerExcitement);

    JLabel lblFocus = new JLabel(ServerConstants.FOCUS);
    lblFocus.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    lblFocus.setBounds(15, 280, 260, 20);
    detectionTab.add(lblFocus);

    spinnerFocus = new JSpinner();
    spinnerFocus.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1));
    JSpinner.NumberEditor editor51 = new JSpinner.NumberEditor(spinnerFocus);
    spinnerFocus.setEditor(editor51);
    spinnerFocus.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    spinnerFocus.setBounds(320, 280, 59, 26);
    detectionTab.add(spinnerFocus);
  }

  /** Construct Expressive Panel */
  public static void constructExpressivePanel() {

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
    upperFaceCombo.setModel(
        new DefaultComboBoxModel(
            new String[] {ServerConstants.EYEBROW_RAISE, ServerConstants.EYEBROW_FURROW}));
    upperFaceCombo.setBounds(560, 130, 173, 26);
    upperFaceCombo.setBackground(Color.WHITE);
    detectionTab.add(upperFaceCombo);

    spinnerUpperFace = new JSpinner();
    spinnerUpperFace.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1));
    JSpinner.NumberEditor editor0 = new JSpinner.NumberEditor(spinnerUpperFace);
    spinnerUpperFace.setEditor(editor0);
    spinnerUpperFace.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    spinnerUpperFace.setBounds(740, 130, 62, 26);
    detectionTab.add(spinnerUpperFace);

    // ---------
    JLabel labelLowerFace = new JLabel("Lower Face:");
    labelLowerFace.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    labelLowerFace.setBounds(430, 160, 127, 20);
    detectionTab.add(labelLowerFace);

    lowerFaceCombo = new JComboBox();
    lowerFaceCombo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    lowerFaceCombo.setModel(
        new DefaultComboBoxModel(
            new String[] {
              ServerConstants.SMILE,
              ServerConstants.CLENCH,
              ServerConstants.SMIRK_LEFT,
              ServerConstants.SMIRK_RIGHT,
              ServerConstants.LAUGH
            }));
    lowerFaceCombo.setBounds(560, 160, 173, 27);
    detectionTab.add(lowerFaceCombo);

    spinnerLowerFace = new JSpinner();
    spinnerLowerFace.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0, 0.1));
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
    comboBoxEye.setModel(
        new DefaultComboBoxModel(
            new String[] {
              ServerConstants.BLINK,
              ServerConstants.LOOKING_LEFT,
              ServerConstants.LOOKING_RIGHT,
              ServerConstants.RIGHT_WINK,
              ServerConstants.LEFT_WINK
            }));
    comboBoxEye.setBounds(560, 190, 173, 29);
    detectionTab.add(comboBoxEye);

    btnActivate = new JToggleButton("Activate");
    btnActivate.setFont(new Font("Times New Roman", Font.PLAIN, 18));

    btnActivate.setBounds(740, 190, 115, 29);
    detectionTab.add(btnActivate);

    detectionAutoResetCheckBox = new JCheckBox("Auto Reset");
    detectionAutoResetCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    detectionAutoResetCheckBox.setBounds(862, 190, 183, 29);
    detectionTab.add(detectionAutoResetCheckBox);
  }
}
