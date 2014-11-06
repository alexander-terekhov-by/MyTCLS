package sample.controller;

import sample.model.Crossing;
import sample.model.enums.RoadOrientation;
import sample.model.road.Line;
import sample.model.road.Road;
import sample.model.trafficLights.TrafficLight;

import java.io.OutputStreamWriter;
import java.util.*;


public class OrdinaryController extends CrossingController {
    private GroupOfNonconflictedLights firstGroupOfLights;
    private GroupOfNonconflictedLights secondGroupOfLights;


	public OrdinaryController(Crossing controlledCrossing){
        super(controlledCrossing);
        firstGroupOfLights = new GroupOfNonconflictedLights();
        secondGroupOfLights = new GroupOfNonconflictedLights();

    }



    @Override
    public void setConflictedLightsToAllLights() {
        //System.out.println(controlledCrossing.toString());
        for(Road oneRoad: controlledCrossing.getAllRoads()) {
            for (Road anotherRoad : controlledCrossing.getAllRoads()) {
                if (!oneRoad.isOppositeRoad(anotherRoad) && oneRoad.getOrientation() != anotherRoad.getOrientation()) {
                    for (Line line : oneRoad.getLines()) {
                        for (Line anotherLine : anotherRoad.getLines()) {
                            line.addConflictLight(anotherLine.getTrafficLight());
                        }
                    }
                }
                else {
                    for (Line line : oneRoad.getLines()) {
                        if(anotherRoad.haveCrosswalk())
                            line.addConflictLight(anotherRoad.getCrosswalk().getPedLight());
                    }
                }
            }
        }
    }
    public void makeGroupOfLights(){
        Road basicRoad = controlledCrossing.getAllRoads().get(0);
        Line basicLine = basicRoad.getLines().get(0);
        TrafficLight basicLight = basicLine.getTrafficLight();
        firstGroupOfLights.addLight(basicLight);
        for(Road oneRoad: controlledCrossing.getAllRoads()) {
                if (!oneRoad.isOppositeRoad(basicRoad) && oneRoad.getOrientation() != basicRoad.getOrientation()) {
                    for (Line line : oneRoad.getLines()) {
                        secondGroupOfLights.addLight(line.getTrafficLight());
                        if(oneRoad.haveCrosswalk()) {
                            firstGroupOfLights.addLight(oneRoad.getCrosswalk().getPedLight());
                        }
                    }
                }
                else {
                    for (Line line : oneRoad.getLines()) {
                        firstGroupOfLights.addLight(line.getTrafficLight());
                        if(oneRoad.haveCrosswalk()) {
                            secondGroupOfLights.addLight(oneRoad.getCrosswalk().getPedLight());
                        }
                    }
                }
        }

    }


    public void playCrossing(){
        firstGroupOfLights.lightGreen();
        secondGroupOfLights.lightRed();


        firstGroupOfLights.lightRed();
        secondGroupOfLights.lightGreen();
    }

}