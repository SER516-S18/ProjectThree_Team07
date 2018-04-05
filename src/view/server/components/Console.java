package view.server.components;

import javax.swing.*;
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
          
        JTextPane consoleTextPane = new JTextPane();
        consoleTextPane.setBounds(15, 30, 538, 103);
        consoleTextPane.setForeground(new Color(255, 0, 51));
        consoleTextPane.setBackground(new Color(255, 255, 255));
      //  console.add(consoleTextPane);
        
        JButton clrLogBtn = new JButton("ClearLog");
        clrLogBtn.setBounds(15, 147, 144, 27);
        clrLogBtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        clrLogBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
			consoleTextPane.setText("");
        	}
        });
        console.add(clrLogBtn);
        
        JScrollPane scrollPane = new JScrollPane(consoleTextPane);
        scrollPane.setBounds(15, 30, 538, 103);
        console.add(scrollPane);
        
//        JScrollBar scrollBarConsole = new JScrollBar();
//        scrollPane.setViewportView(scrollBarConsole);
       // return console;
    }
   
    
	public static void setErrorMessage(String errorMessage) {

		try
		{
			console = new JPanel();

	        console.setPreferredSize(new Dimension(600, 190));
	        console.setLayout(null);

	        JLabel consoleLabel = new JLabel("Console");
	        consoleLabel.setBounds(15, -1, 119, 27);
	        consoleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	        console.add(consoleLabel);
	       
	        JTextPane consoleTextPane = new JTextPane();
	        
			consoleTextPane.setContentType(CONTENT_TYPE);
			StyledDocument doc = (StyledDocument) consoleTextPane.getDocument();
			SimpleAttributeSet keyWord = new SimpleAttributeSet();
			StyleConstants.setForeground(keyWord, Color.RED);
			StyleConstants.setFontFamily(keyWord, "Times New Roman");
			StyleConstants.setFontSize(keyWord, 9);
			StyleConstants.setBackground(keyWord, Color.LIGHT_GRAY);

			doc.insertString(0,new Date()+" - Error - "+errorMessage +"\n",keyWord );
			
			JButton clrLogBtn = new JButton("ClearLog");
	        clrLogBtn.setBounds(15, 147, 144, 27);
	        clrLogBtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	        clrLogBtn.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        	}
	        });
	        console.add(clrLogBtn);
	        
	        JScrollPane scrollPane = new JScrollPane(consoleTextPane);
	        scrollPane.setBounds(15, 30, 538, 103);
	        console.add(scrollPane);
		}
		catch(Exception ex) 
		{ 
			LOGGER.log(Level.SEVERE,"Exception while adding Error Message.", ex); 
		}

	}

	/**
	 * sets the layout for normal messages
	 * @param message
	 */
	public static void setMessage(String message) {
		try {
			console = new JPanel();

	        console.setPreferredSize(new Dimension(600, 190));
	        console.setLayout(null);

	        JTextPane consoleTextPane = new JTextPane();

			consoleTextPane.setContentType(CONTENT_TYPE);
			StyledDocument doc = (StyledDocument) consoleTextPane.getDocument();
			SimpleAttributeSet keyWord = new SimpleAttributeSet();
			StyleConstants.setForeground(keyWord, Color.BLACK);
			StyleConstants.setFontFamily(keyWord, "Times New Roman");
			StyleConstants.setFontSize(keyWord, 9);
			StyleConstants.setBackground(keyWord, Color.LIGHT_GRAY);
			doc.insertString(0,new Date()+"- Message - "+message+"\n",keyWord );
		} catch (Exception ex) {
			LOGGER.log(Level.SEVERE,"Exception while adding Message", ex);
		}
	}


}
