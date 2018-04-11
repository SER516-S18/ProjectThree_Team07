package view.server.components;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

/** @autho Team 7 Console View */
public class Console {

  private static JPanel console = null;
  private static final Logger LOGGER = Logger.getLogger(Console.class.getName());
  private static final String CONTENT_TYPE = "text/html";
  private static JTextPane consoleTextPane = null;
  private static int consoleCounter = 1;

  /** @wbp.parser.entryPoint */
  public static JPanel getConsolePanel() {
    if (console == null) {
      getPanel();
    }
    return console;
  }

  /** Panel for console */
  public static void getPanel() {
    console = new JPanel();
    console.setPreferredSize(new Dimension(1000, 200));
    console.setLayout(null);

    JLabel consoleLabel = new JLabel("Console");
    consoleLabel.setBounds(15, 5, 119, 27);
    consoleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    console.add(consoleLabel);

    if (consoleTextPane == null) {
      consoleTextPane = new JTextPane();
      consoleTextPane.setBounds(15, 30, 538, 150);
      consoleTextPane.setForeground(new Color(255, 0, 51));
      consoleTextPane.setBackground(Color.WHITE);
    }

    JScrollPane scrollPane = new JScrollPane(consoleTextPane);
    scrollPane.setBounds(15, 30, 970, 103);
    console.add(scrollPane);

    JButton clrLogBtn = new JButton("ClearLog");
    clrLogBtn.setBounds(440, 150, 144, 27);
    clrLogBtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    clrLogBtn.addActionListener(
        new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            consoleTextPane.setContentType(CONTENT_TYPE);
            HTMLDocument doc = (HTMLDocument) consoleTextPane.getDocument();
            try {
              doc.remove(0, doc.getLength());
            } catch (BadLocationException e) {
              LOGGER.log(Level.SEVERE, "Exception while clearing Console", e);
              e.printStackTrace();
            }
            consoleCounter = 1;
          }
        });
    console.add(clrLogBtn);
  }

  /**
   * setErrorMessage
   *
   * @param errorMessage - Error message that has to be displayed
   */
  public static void setErrorMessage(String errorMessage) {
    try {
      consoleTextPane.setContentType(CONTENT_TYPE);
      HTMLDocument doc = (HTMLDocument) consoleTextPane.getDocument();
      doc.insertAfterEnd(
          doc.getCharacterElement(doc.getLength()),
          "<span style=\"color:red\">"
              + consoleCounter
              + ":["
              + new Date()
              + "] "
              + errorMessage
              + "</span> <br>");
      consoleCounter++;
    } catch (Exception ex) {
      LOGGER.log(Level.SEVERE, "Exception while adding Error Message.", ex);
    }
  }

  /**
   * sets the layout and normal messages
   *
   * @param message to be displayed
   */
  public static void setMessage(String message) {
    try {
      consoleTextPane.setContentType(CONTENT_TYPE);
      HTMLDocument doc = (HTMLDocument) consoleTextPane.getDocument();
      doc.insertAfterEnd(
          doc.getCharacterElement(doc.getLength()),
          "<span style=\"color:black\">"
              + consoleCounter
              + ":["
              + new Date()
              + "] "
              + message
              + "</span> <br>");
      consoleCounter++;

    } catch (Exception ex) {
      LOGGER.log(Level.SEVERE, "Exception while adding Message to client console", ex);
    }
  }
}
