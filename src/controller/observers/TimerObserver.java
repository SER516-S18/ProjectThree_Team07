package controller.observers;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import network.model.Status;
import network.model.StatusObservable;

/**
 * @author Team 7
 * Observer for timestamp
 */
public class TimerObserver implements Observer {

	private static TimerObserver timerObserverInstance = null;
	
	public static TimerObserver getInstance() {
		if (timerObserverInstance == null) {
			timerObserverInstance = new TimerObserver();
		}
		return timerObserverInstance;
	}

  /**
   * Updates timestamp values
   * @param observable
   * @param arg
   */
	@Override
	public void update(Observable observable, Object arg) {		
		ArrayList<Status> statusContainer = StatusObservable.getObserverInstance().getStatusContainer(); 
		Status status = statusContainer.get(statusContainer.size()-1);
		view.client.Client.getTimestampValLabel().setText(status.getTimestamp() + "");;
	}

}