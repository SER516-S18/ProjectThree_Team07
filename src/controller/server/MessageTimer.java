package controller.server;

import javax.swing.Timer;

import network.model.Status;
import view.server.components.attributes.AttributeContainer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Team 7
 * A Timer singleton that runs repetitively for the specified interval
 */
public class MessageTimer {
	private boolean isAutoRepeated = false;
	private Timer timer;
	private double timeCounter = (double) 0.0;

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
	 * @param double interval - interval in which data has to sent to the client
   * @param boolean isAutoRepeated
	 */
	public void startTimer(double interval,boolean isAutoRepeated) {
		this.isAutoRepeated = isAutoRepeated;
		int delay = isAutoRepeated? (int) Math.round(interval * 1000) : 0;
		timer = new Timer(delay, new ActionListener() {
			public void actionPerformed( ActionEvent event )  {
				MessageSender.sendData();
				updateTimer(interval);
				AttributeContainer.setTimeTextField(String.valueOf(getTimerInSeconds()));
				Status.getInstance().setTimestamp(getTimerInSeconds());
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
   * @param boolean autoRepeated
	 */
	public void setAutoRepeated(boolean autoRepeated) {
		this.isAutoRepeated = autoRepeated;
	}

  /**
   * Update time
   * @param double interval
   */
	void updateTimer(double interval) {
		timeCounter += interval; 
	}

  /**
   * Get timer in seconds
   * @return double time counter
   */
	double getTimerInSeconds() {
		return Math.round(timeCounter * 100.0) / 100.0;
	}

  /**
   *  Set timer
   * @param double time
   */
	public void setTimer(double time) {
		timeCounter = time;
	}
}
