package sample.model.trafficLights;

import sample.model.Detector;

import java.util.List;


public abstract class TrafficLight {

	private List<TrafficLight> conflictLights;
	private List<TrafficLight> nonConflictedLights;
	private int timeForRed;
	private int timeForGreen;
	private Detector detector;



	public void light(){}

	public void setGreenTime(int time){
        timeForGreen = time;

	}
	public void setRedTime(int time){
        timeForRed = time;
	}
    public void addConflictLight(TrafficLight light){
        conflictLights.add(light);
    }
}