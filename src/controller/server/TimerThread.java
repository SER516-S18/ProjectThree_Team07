package controller.server;

import java.util.logging.Level;
import java.util.logging.Logger;

import network.model.Status;

/**
 * A Timer thread that runs repetitively for the specified interval
 * 
 * @author raam
 *
 */
public class TimerThread {
	private static Thread thread = null;
	private static float counter = (float) 0.0;
	private static boolean isThreadAlive = false;
	private static final Logger LOGGER = Logger.getLogger(TimerThread.class.getName());
	
	/**
	 * Constructs and starts the timer thread
	 * 
	 * @param interval - interval in which data has to sent to the client
	 */
	public static void startTimer(float interval) {
		if (thread == null || !isThreadAlive) {
			isThreadAlive = true;
			thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(isThreadAlive) {
							try {
								//TODO Display Time call
								System.out.println("\n timer time " + counter);
								MessageSender.sendData();
								Thread.sleep((int) (interval * 1000));
								counter += interval;
							} catch (InterruptedException e) {
								Thread.currentThread().interrupt();
								LOGGER.log(Level.SEVERE, "Interupter exception while thread sleeps", e);
								break;
							}
					}
				}
			});
			thread.start();
		} else {
			LOGGER.log(Level.INFO, "Thread is already running, thread state - " + thread.getState());
		}
	}
	
	/**
	 * Stops the timer thread
	 */
	public static void stopTimer() {
		isThreadAlive = false;
		if (thread != null) {
			thread.interrupt();
		}
	}
	
	/**
	 * Stops and clear the timer thread
	 */
	public static void clearTimer() {
		isThreadAlive = false;
		counter = (float) 0.0;
		if (thread != null) {
			thread.interrupt();
		}
	}
	
	/**
	 * Sets the value passed to the counter
	 * 
	 * @param valueToSet - sets this value to the counter
	 */
	public static void setCounter(float valueToSet) {
		counter = valueToSet;
	}
	
	/**
	 * get value currently in the counter 
	 * 
	 * @returns the counter value
	 */
	public static float getCounter() {
		return counter;
	}
}
