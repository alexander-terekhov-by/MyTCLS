package sample.controller;

import sample.model.Crossing;
import sample.model.trafficLights.TrafficLight;
import java.util.List;

public abstract class CrossingController {

	private List<List<TrafficLight>> queueOfLightingLights;
	protected Crossing controlledCrossing;

	public CrossingController(){}
	public void playCrossing(){}
	public void useDetector(){}
    public abstract void makeQueue();
    public abstract void setConflictedLightsToAllLights();



}