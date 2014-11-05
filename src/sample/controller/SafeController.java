package sample.controller;

import sample.model.Crossing;
import sample.model.trafficLights.TrafficLight;

import java.util.List;


public class SafeController extends CrossingController {

	public SafeController(Crossing controlledCrossing){
        super(controlledCrossing);
    }


	public void makeQueue(){

	}

    @Override
    public void setConflictedLightsToAllLights() {

    }

    public void playCrossing(){

	}

	public void useDetector(){

	}


}