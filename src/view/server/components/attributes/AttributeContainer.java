package view.server.components.attributes;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class AttributeContainer {
	private static JTextField textField;

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
        detectionTab.setFont(new Font("Times New Roman", Font.PLAIN, 20));
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
        
        textField = new JTextField();
        textField.setBounds(66, 58, 146, 26);
        detectionTab.add(textField);
        textField.setColumns(10);
        
        JLabel labelSec = new JLabel("sec");
        labelSec.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        labelSec.setBounds(224, 61, 69, 20);
        detectionTab.add(labelSec); 
       
        JLabel labelUpperFace = new JLabel("Upper Face:");
        labelUpperFace.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        labelUpperFace.setBounds(15, 189, 197, 20);
        detectionTab.add(labelUpperFace);
        
        JComboBox upperFaceCombo1 = new JComboBox();
        upperFaceCombo1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        upperFaceCombo1.setModel(new DefaultComboBoxModel(new String[] {"Raise Brow", "Furrow Brow"}));
        upperFaceCombo1.setBounds(25, 225, 173, 26);
        upperFaceCombo1.setBackground(Color.WHITE);
        detectionTab.add(upperFaceCombo1);
        
        JSpinner spinnerUpperFace = new JSpinner();
        spinnerUpperFace.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
        JSpinner.NumberEditor editor0 = new JSpinner.NumberEditor(spinnerUpperFace);
        spinnerUpperFace.setEditor(editor0);
        spinnerUpperFace.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        spinnerUpperFace.setBounds(201, 225, 62, 26);
        detectionTab.add(spinnerUpperFace);
        
        JLabel labelLowerFace = new JLabel("Lower Face:");
        labelLowerFace.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        labelLowerFace.setBounds(324, 189, 127, 20);
        detectionTab.add(labelLowerFace);
        
        JComboBox lowerFaceCombo1 = new JComboBox();
        lowerFaceCombo1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lowerFaceCombo1.setModel(new DefaultComboBoxModel(new String[] {"Smile", "Clench", "Laugh"}));
        lowerFaceCombo1.setBounds(324, 225, 155, 27);
        detectionTab.add(lowerFaceCombo1);
        
        JSpinner spinnerLowerFace = new JSpinner();
        spinnerLowerFace.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinnerLowerFace);
        spinnerLowerFace.setEditor(editor);
        spinnerLowerFace.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        spinnerLowerFace.setBounds(487, 225, 62, 26);
        detectionTab.add(spinnerLowerFace);
        
        JLabel labelEye = new JLabel("Eye");
        labelEye.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        labelEye.setBounds(15, 267, 69, 20);
        detectionTab.add(labelEye);
        
        JComboBox comboBoxEye = new JComboBox();
        comboBoxEye.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        comboBoxEye.setModel(new DefaultComboBoxModel(new String[] {"Blink", "Looking Left", "Looking Right", "Looking Up", "Looking Down"}));
        comboBoxEye.setBounds(25, 303, 173, 29);
        detectionTab.add(comboBoxEye);
        
        JButton btnActivate = new JButton("Activate");
        btnActivate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnActivate.setBounds(225, 303, 115, 29);
        detectionTab.add(btnActivate);
        
        JCheckBox detectionCheckBox = new JCheckBox("Auto Reset");
        detectionCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        detectionCheckBox.setBounds(366, 303, 183, 29);
        detectionTab.add(detectionCheckBox);
        
        JLabel labelAffective = new JLabel("Affective");
        labelAffective.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        labelAffective.setBounds(15, 97, 76, 20);
        detectionTab.add(labelAffective);
        
        JLabel lblExcitement = new JLabel("Excitement");
        lblExcitement.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblExcitement.setBounds(106, 100, 96, 20);
        detectionTab.add(lblExcitement);
        
        JLabel lblEngagementboredom = new JLabel("Engagement/Boredom");
        lblEngagementboredom.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblEngagementboredom.setBounds(106, 136, 174, 20);
        detectionTab.add(lblEngagementboredom);
        
        JSpinner spinnerExcitement = new JSpinner();
        spinnerExcitement.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
        JSpinner.NumberEditor editor1 = new JSpinner.NumberEditor(spinnerExcitement);
        spinnerExcitement.setEditor(editor1);
        spinnerExcitement.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        spinnerExcitement.setBounds(281, 97, 59, 26);
        detectionTab.add(spinnerExcitement);
        
        JSpinner spinnerEngagement = new JSpinner();
        spinnerEngagement.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
        JSpinner.NumberEditor editor2 = new JSpinner.NumberEditor(spinnerEngagement);
        spinnerEngagement.setEditor(editor2);
        spinnerEngagement.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        spinnerEngagement.setBounds(281, 133, 59, 26);
        detectionTab.add(spinnerEngagement);
        
        
        JLabel lblLongTerm = new JLabel("Long Term");
        lblLongTerm.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblLongTerm.setBounds(364, 100, 86, 20);
        detectionTab.add(lblLongTerm);
        
        JSpinner spinnerLongTerm = new JSpinner();
        spinnerLongTerm.setModel(new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.01));
        JSpinner.NumberEditor editor3 = new JSpinner.NumberEditor(spinnerLongTerm);
        spinnerLongTerm.setEditor(editor3);
        spinnerLongTerm.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        spinnerLongTerm.setBounds(464, 97, 59, 26);
        detectionTab.add(spinnerLongTerm);
        tabbedPane.setEnabledAt(0, true);
        return attributeContainer;
    }
}
