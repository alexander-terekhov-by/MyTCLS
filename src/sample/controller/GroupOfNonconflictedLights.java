package sample.controller;

import sample.model.trafficLights.TrafficLight;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Александр on 06.11.2014.
 */
public class GroupOfNonconflictedLights {
    private Set<TrafficLight> groupOfLights;

    public GroupOfNonconflictedLights() {
        this.groupOfLights = new HashSet<TrafficLight>();
    }

    public void addLight(TrafficLight light) {
        groupOfLights.add(light);
    }

    public void lightGreen() {

        for (TrafficLight light : groupOfLights) {
            light.lightGreen();
        }
    }


    public void lightRed() {

        for (TrafficLight light : groupOfLights) {
            light.lightRed();
        }
    }

    public void lightYellow() {
        for (TrafficLight light : groupOfLights) {
              light.lightYellow();
        }
    }

    public void lightYellowAndRed() {
        for (TrafficLight light : groupOfLights) {
            light.lightYellowAndRed();
        }
    }

    public  void skipCar(){
        for (TrafficLight light : groupOfLights) {
            light.getDetector().skipUnit();
        }

    }

    @Override
    public String toString() {
        return groupOfLights.toString();
    }
}
