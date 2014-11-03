package sample.model;

import java.util.List;


public abstract class TrafficLight {

	private List<TrafficLight> ConflictLights;
	private List<TrafficLight> NonConflictedLights;
	private int timeForRed;
	private int timeForGreen;
	private Detector detector;



	public void light(){

	}

	/**
	 * 
	 * @param time
	 */
	public void setGreenTime(int time){

	}

	/**
	 * 
	 * @param time
	 */
	public void setRedTime(int time){

	}
}