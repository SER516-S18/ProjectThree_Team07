package network.model;

import java.util.ArrayList;
import java.util.Observable;
import controller.observers.*;

/** @author Team 7 Observable for Status obvject */
public class StatusObservable extends Observable {
  private ArrayList<Status> statusContainer = new ArrayList<Status>();
  private static StatusObservable observerInstance = null;

  /**
   * StatusObservable for Observable instance
   *
   * @return StatusObservable observerInstance
   */
  public static StatusObservable getObserverInstance() {
    if (observerInstance == null) {
      observerInstance = new StatusObservable();
      observerInstance.addObserver(FaceObserver.getInstance());
      observerInstance.addObserver(GraphObserver.getInstance());
      observerInstance.addObserver(TimerObserver.getInstance());
    }
    return observerInstance;
  }

  /**
   * Adds status and notifies observers
   *
   * @param Status status
   */
  public void addStatus(Status status) {
    observerInstance.statusContainer.add(status);
    observerInstance.setChanged();
    observerInstance.notifyObservers();
  }

  /**
   * Holds all the status messages received
   *
   * @return ArrayList<Status> statusContainer
   */
  public ArrayList<Status> getStatusContainer() {
    return observerInstance.statusContainer;
  }
}
