package sample.controller;

import sample.model.Crossing;
import sample.model.trafficLights.TrafficLight;
import java.util.List;

public abstract class CrossingController {


	protected Crossing controlledCrossing;
    protected int sessionTime;

	public CrossingController(Crossing crossing){
        controlledCrossing = crossing;
        sessionTime = 10;
    }
	public void playCrossing(){}
	public void useDetector(){}
    public abstract void makeGroupOfLights();
    public abstract void setConflictedLightsToAllLights();
    public void setSessionTime(int sessionTime) {
        this.sessionTime = sessionTime;
    }
}