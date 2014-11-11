package sample.controller;

import javafx.application.Platform;
import sample.model.Crossing;
import sample.model.road.Line;
import sample.model.road.Road;
import sample.model.trafficLights.TrafficLight;
import sample.view.drawers.CrossingDrawer;

import java.util.Timer;
import java.util.TimerTask;


public class OrdinaryController extends CrossingController {
    private GroupOfNonconflictedLights firstGroupOfLights;
    private GroupOfNonconflictedLights secondGroupOfLights;


    public OrdinaryController(Crossing controlledCrossing, CrossingDrawer drawer) {
        super(controlledCrossing, drawer);
        firstGroupOfLights = new GroupOfNonconflictedLights();
        secondGroupOfLights = new GroupOfNonconflictedLights();
    }

    @Override
    /*public void setConflictedLightsToAllLights() {
        //System.out.println(controlledCrossing.toString());
        for (Road oneRoad : controlledCrossing.getAllRoads()) {
            for (Road anotherRoad : controlledCrossing.getAllRoads()) {
                if (!oneRoad.isOppositeRoad(anotherRoad) && oneRoad.getOrientation() != anotherRoad.getOrientation()) {
                    for (Line line : oneRoad.getLines()) {
                        for (Line anotherLine : anotherRoad.getLines()) {
                            line.addConflictLight(anotherLine.getTrafficLight());
                        }
                    }
                } else {
                    for (Line line : oneRoad.getLines()) {
                        if (anotherRoad.haveCrosswalk())
                            line.addConflictLight(anotherRoad.getCrosswalk().getPedLight());
                    }
                }
            }
        }
    }*/

    public void makeGroupOfLights() {
        Road basicRoad = controlledCrossing.getAllRoads().get(0);
        Line basicLine = basicRoad.getLines().get(0);
        TrafficLight basicLight = basicLine.getTrafficLight();
        firstGroupOfLights.addLight(basicLight);
        for (Road oneRoad : controlledCrossing.getAllRoads()) {
            if (!oneRoad.isOppositeRoad(basicRoad) && oneRoad.getOrientation() != basicRoad.getOrientation()) {
                for (Line line : oneRoad.getLines()) {
                    secondGroupOfLights.addLight(line.getTrafficLight());
                    if (oneRoad.haveCrosswalk()) {
                        firstGroupOfLights.addLight(oneRoad.getCrosswalk().getPedLight());
                    }
                }
            } else {
                for (Line line : oneRoad.getLines()) {
                    firstGroupOfLights.addLight(line.getTrafficLight());
                    if (oneRoad.haveCrosswalk()) {
                        secondGroupOfLights.addLight(oneRoad.getCrosswalk().getPedLight());
                    }
                }
            }
        }
    }

    public void playCrossing() {
               timer.schedule(new LightController(), 1000, 1000);
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
                    skipCars();
                }
            });
        }

        private void setMiddle() {
            OrdinaryController.this.checkDetector();
            System.out.println(secondsForFirstGroup);
            secondsForFirstGroup = OrdinaryController.this.getMiddleTime();
        }

        private void skipCars() {
            if (seconds < secondsForFirstGroup) {
                secondGroupOfLights.skipCar();
            }
            if (seconds > secondsForFirstGroup && seconds < sessionTime) {
                firstGroupOfLights.skipCar();
            }
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
