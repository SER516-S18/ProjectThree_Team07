package view.server.components;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class Console {

	private static JPanel console = null;
	private final static Logger LOGGER = Logger.getLogger(Console.class.getName());
	private final static String CONTENT_TYPE = "text/html";
	private static JTextPane consoleTextPane = null;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static JPanel getConsolePanel()
	{
		if(console == null)
		{	
			getPanel();
		}
		return console;
	}

	public static void getPanel() {
		console = new JPanel();

		console.setPreferredSize(new Dimension(600, 190));
		console.setLayout(null);

		JLabel consoleLabel = new JLabel("Console");
		consoleLabel.setBounds(15, -1, 119, 27);
		consoleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		console.add(consoleLabel);

		if(consoleTextPane == null) {
			consoleTextPane = new JTextPane();
			consoleTextPane.setBounds(15, 30, 538, 103);
			consoleTextPane.setForeground(new Color(255, 0, 51));
			consoleTextPane.setBackground(new Color(255, 255, 255));
		}

		JScrollPane scrollPane = new JScrollPane(consoleTextPane);
		scrollPane.setBounds(15, 30, 538, 103);
		console.add(scrollPane);

		JButton clrLogBtn = new JButton("ClearLog");
		clrLogBtn.setBounds(15, 147, 144, 27);
		clrLogBtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		clrLogBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consoleTextPane.setContentType(CONTENT_TYPE);
				StyledDocument doc = (StyledDocument) consoleTextPane.getDocument();
				try {
					doc.remove(0, doc.getLength());
					//doc.insertString(0,null,null );
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		console.add(clrLogBtn);
	}

	public static void setErrorMessage(String errorMessage) {
		try
		{
			consoleTextPane = new JTextPane();
			consoleTextPane.setContentType(CONTENT_TYPE);
			StyledDocument doc = (StyledDocument) consoleTextPane.getDocument();
			SimpleAttributeSet keyWord = new SimpleAttributeSet();
			StyleConstants.setForeground(keyWord, Color.RED);
			doc.insertString(0,new Date()+" - Error - "+errorMessage +"\n",keyWord );
		}
		catch(Exception ex) 
		{ 
			LOGGER.log(Level.SEVERE,"Exception while adding Error Message.", ex); 
		}

	}

	/**
	 * sets the layout and normal messages
	 * @param message to be displayed
	 */
	public static void setMessage(String message) {
		try {
			consoleTextPane = new JTextPane();
			consoleTextPane.setContentType(CONTENT_TYPE);
			StyledDocument doc = (StyledDocument) consoleTextPane.getDocument();
			doc.insertString(0,new Date()+"- Message - "+message+"\n",null );
		} catch (Exception ex) {
			LOGGER.log(Level.SEVERE,"Exception while adding Message", ex);
		}
	}

}
