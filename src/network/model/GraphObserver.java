package network.model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import view.client.components.affective.AffectiveTimeSeriesGraph;
import view.client.components.expressive.ExpressiveTimeSeriesGraph;

public class GraphObserver implements Observer {
	private static GraphObserver graphObserverInstance = null;
	
	public static GraphObserver getInstance() {
		if (graphObserverInstance == null) {
			graphObserverInstance = new GraphObserver();
		}
		return graphObserverInstance;
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		ArrayList<Status> statusContainer = StatusObservable.getObserverInstance().getStatusContainer(); 
		Status status = statusContainer.get(statusContainer.size()-1);
		
		AffectiveTimeSeriesGraph.getinstance().update(status);
        ExpressiveTimeSeriesGraph.getinstance().update(status);
	}
}
