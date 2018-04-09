package controller.server;

public class ApplicationTimer {
	private static ApplicationTimer timer = null;
	private float timeCounter = (float) 0.0;
	
	public static ApplicationTimer getInstance() {
		if (timer == null) {
			timer = new ApplicationTimer();
		}
		return timer;
	}
	
	void updateTimer(float interval) {
		timeCounter += interval; 
	}
	
	float getTimer() {
		return timeCounter;
	}
	
	public void setTimer(float time) {
		timeCounter = time;
	}
}
