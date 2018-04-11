package controller.observers;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import network.model.Status;
import network.model.StatusObservable;
import view.client.components.affective.AffectiveTimeSeriesGraph;
import view.client.components.expressive.ExpressiveTimeSeriesGraph;

/** @author Team 7
 * Observer for graph data
 * */
public class GraphObserver implements Observer {
  private static GraphObserver graphObserverInstance = null;

  /**
   * GraphObserver singleton instance
   * @return GraphObserver graphObserverInstance
   */
  public static GraphObserver getInstance() {
    if (graphObserverInstance == null) {
      graphObserverInstance = new GraphObserver();
    }
    return graphObserverInstance;
  }

  /**
   * Updates the graph status data
   * @param observable
   * @param arg
   */
  @Override
  public void update(Observable observable, Object arg) {
    ArrayList<Status> statusContainer = StatusObservable.getObserverInstance().getStatusContainer();
    Status status = statusContainer.get(statusContainer.size() - 1);

    AffectiveTimeSeriesGraph.getinstance().update(status);
    ExpressiveTimeSeriesGraph.getinstance().update(status);
  }
}
