package sample.controller;

import javafx.application.Platform;
import sample.model.Crossing;
import sample.model.enums.LineDirection;
import sample.model.enums.RoadOrientation;
import sample.model.road.Line;
import sample.model.road.Road;
import sample.model.trafficLights.TrafficLight;
import sample.view.drawers.CrossingDrawer;

import java.util.TimerTask;


public class SafeController extends CrossingController {
    private GroupOfNonconflictedLights firstGroupOfLights;
    private GroupOfNonconflictedLights secondGroupOfLights;
    private GroupOfNonconflictedLights thirdGroupOfLights;
    private GroupOfNonconflictedLights fourthGroupOfLights;
    private GroupOfNonconflictedLights fifthGroupOfLights;


    public SafeController(Crossing controlledCrossing, CrossingDrawer drawer) {
        super(controlledCrossing, drawer);
    }

    public void playCrossing() {
        timer.schedule(new LightController(), 1000, 1000);
    }


    @Override
    public void makeGroupOfLights() {
        for (Road oneRoad : controlledCrossing.getAllRoads()) {
            if (oneRoad.haveCrosswalk())
                firstGroupOfLights.addLight(oneRoad.getCrosswalk().getPedLight());
            for (Line line : oneRoad.getLines()) {
                if (oneRoad.getOrientation() == RoadOrientation.NORTH || oneRoad.getOrientation() == RoadOrientation.SOUTH) {
                    if (line.getDirection() == LineDirection.TO_LEFT)
                        thirdGroupOfLights.addLight(line.getTrafficLight());
                    else
                        secondGroupOfLights.addLight(line.getTrafficLight());
                } else if (oneRoad.getOrientation() == RoadOrientation.WEST || oneRoad.getOrientation() == RoadOrientation.EAST){
                    if (line.getDirection() == LineDirection.TO_LEFT)
                        fifthGroupOfLights.addLight(line.getTrafficLight());
                    else
                        fourthGroupOfLights.addLight(line.getTrafficLight());
                }
            }
        }


    }
    private class LightController extends TimerTask {
        private int seconds = 0;
        private int secondsForFirstGroup;

        public void run() {
            seconds++;
            if (seconds > sessionTime) {
                seconds = 0;
                setMiddle();
            }

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    lightGroupOfLights();
                    //skipCars();
                }
            });
        }

        private void setMiddle() {
            SafeController.this.checkDetector();
            System.out.println(secondsForFirstGroup);
            secondsForFirstGroup = SafeController.this.getMiddleTime();
        }


        private void lightGroupOfLights() {
            if (seconds == 1) {
                firstGroupOfLights.lightYellowAndRed();
                secondGroupOfLights.lightYellow();
            } else if (seconds == 2) {
                firstGroupOfLights.lightGreen();
                secondGroupOfLights.lightRed();
            } else if (seconds == (secondsForFirstGroup)) {
                firstGroupOfLights.lightYellow();
                secondGroupOfLights.lightYellowAndRed();
            } else if (seconds == (secondsForFirstGroup + 1)) {
                firstGroupOfLights.lightRed();
                secondGroupOfLights.lightGreen();
            }
        }
    }
}


