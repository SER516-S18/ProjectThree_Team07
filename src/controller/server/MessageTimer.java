package controller.server;

import javax.swing.Timer;

import view.server.components.attributes.AttributeContainer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A Timer singleton that runs repetitively for the specified interval
 *
 */
public class MessageTimer {
	private boolean isAutoRepeated = false;
	private Timer timer;

	private static MessageTimer timerInstance = null;

	private MessageTimer() {}

	public static MessageTimer getInstance() {
		if (timerInstance == null) {
			timerInstance = new MessageTimer();
		}
		return timerInstance;
	}

	/**
	 * Constructs and starts the timer thread
	 * 
	 * @param interval - interval in which data has to sent to the client
	 */
	public void startTimer(float interval) {
		timer = new Timer( Math.round(interval * 1000), new ActionListener() {
			public void actionPerformed( ActionEvent event )  {
				ApplicationTimer.getInstance().updateTimer(interval);
				MessageSender.sendData();
				AttributeContainer.setTimeTextField(ApplicationTimer.getInstance() + "");
			}
		});
		timer.setRepeats(this.isAutoRepeated);
		timer.start();
	}
	
	/**
	 * Stops the timer thread
	 */
	public void stopTimer() {
		timer.stop();
	}

	/**
	 * Sets if the timer should repeat or not
	 */
	public void setAutoRepeated(boolean autoRepeated) {
		this.isAutoRepeated = autoRepeated;
	}
}
