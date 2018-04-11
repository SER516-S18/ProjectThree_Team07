package network.model;

import java.util.ArrayList;
import java.util.Observable;

public class StatusObservable extends Observable {
	private ArrayList<Status> statusContainer = new ArrayList<Status>();
	private static StatusObservable observerInstance = null;
	
	public static StatusObservable getObserverInstance() {
		if (observerInstance == null) {
			observerInstance = new StatusObservable();
			observerInstance.addObserver(FaceObserver.getInstance());
			observerInstance.addObserver(GraphObserver.getInstance());
			observerInstance.addObserver(TimerObserver.getInstance());
		}
		return observerInstance;
	}
	
	public void addStatus(Status status) {
		observerInstance.statusContainer.add(status);
		observerInstance.setChanged();
		observerInstance.notifyObservers();
	}
	
	public ArrayList<Status> getStatusContainer() {
		return observerInstance.statusContainer;
	}
	
}
