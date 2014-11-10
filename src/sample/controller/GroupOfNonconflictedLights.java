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
            System.out.println("Group green light");
            light.lightGreen();
        }
    }

    public void lightRed() {
        for (TrafficLight light : groupOfLights) {
            System.out.println("Group red light");
            light.lightRed();
        }
    }

    @Override
    public String toString() {
        return groupOfLights.toString();
    }
}
