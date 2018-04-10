package network.model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import controller.client.FacialExpressionSolver;
import view.client.ImageLoader;
import view.client.components.expressive.FacialExpressions;

public class FaceObserver implements Observer {

	private static FaceObserver faceObserverInstance = null;
	
	public static FaceObserver getInstance() {
		if (faceObserverInstance == null) {
			faceObserverInstance = new FaceObserver();
		}
		return faceObserverInstance;
	}
	
	@Override
	public void update(Observable observable, Object arg) {		
		ArrayList<Status> statusContainer = StatusObservable.getObserverInstance().getStatusContainer(); 
		Status status = statusContainer.get(statusContainer.size()-1);
		
		FacialExpressionSolver.LowerFace lowerFace = FacialExpressionSolver.computeLowerFace(status);
		FacialExpressionSolver.UpperFace upperFace = FacialExpressionSolver.computeUpperrFace(status);
		ImageLoader.loadImage(FacialExpressions.getPanel(), upperFace.getFileName(), lowerFace.getFileName());
	}

}
