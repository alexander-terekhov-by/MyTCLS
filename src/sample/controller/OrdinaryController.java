package sample.controller;

import sample.model.enums.RoadOrientation;
import sample.model.road.Line;
import sample.model.road.Road;
import sample.model.trafficLights.TrafficLight;

import java.util.List;


public class OrdinaryController extends CrossingController {

	public OrdinaryController(){}
	public void makeQueue(){

	}

    @Override
    public void setConflictedLightsToAllLights() {
        for(Road oneRoad: controlledCrossing.getAllRoads())
            for(Road anotherRoad: controlledCrossing.getAllRoads())
                if(!oneRoad.isOppositeRoad(anotherRoad) && oneRoad.getOrientation() != anotherRoad.getOrientation())
                    for(Line line : oneRoad.getLines())
                        for(Line anotherLine : anotherRoad.getLines()) {
                            line.addConflictLight(anotherLine.getTrafficLight());
                        }
    }
    public void playCrossing(){

    }
}