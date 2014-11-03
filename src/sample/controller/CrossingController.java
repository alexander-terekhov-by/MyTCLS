package sample.controller;


import sample.model.Crossing;
import sample.model.TrafficLight;

import java.util.List;

public abstract class CrossingController {

	private List<List<TrafficLight>> queueOfLightingLights;
	private Crossing controlledCrossing;

	public CrossingController(){}
	public List<List<TrafficLight>> makeQueue(){
		return null;
	}
	public void playCrossing(){}
	public void useDetector(){}
}