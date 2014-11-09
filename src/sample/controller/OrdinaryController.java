package sample.controller;

import javafx.application.Platform;
import sample.model.Crossing;
import sample.model.road.Line;
import sample.model.road.Road;
import sample.model.trafficLights.TrafficLight;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Timer;
import java.util.TimerTask;


public class OrdinaryController extends CrossingController {
    private GroupOfNonconflictedLights firstGroupOfLights;
    private GroupOfNonconflictedLights secondGroupOfLights;


    public OrdinaryController(Crossing controlledCrossing) {
        super(controlledCrossing);
        firstGroupOfLights = new GroupOfNonconflictedLights();
        secondGroupOfLights = new GroupOfNonconflictedLights();

    }


    @Override
    public void setConflictedLightsToAllLights() {
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
    }

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
        Timer timer = new Timer("LOL");
        System.out.println(firstGroupOfLights.toString());
        System.out.println(secondGroupOfLights.toString());
        timer.schedule(new MyTimerTask(2), 1000, 1000);

    }

    private class MyTimerTask extends TimerTask {
        private int seconds = 0;
        private int secondsForFirstGroup;

        private MyTimerTask(int secondsForFirstGroup) {
            this.secondsForFirstGroup = secondsForFirstGroup;
        }


        public void run() {
            seconds++;
            //System.out.println(seconds);
            if (seconds > 4)
              seconds = 0;
               // this.cancel();

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (seconds == 1) {
                        firstGroupOfLights.lightGreen();
                        secondGroupOfLights.lightRed();
                        System.out.println("1Green");
                    } else if (seconds == (secondsForFirstGroup + 1)) {
                        firstGroupOfLights.lightRed();
                        secondGroupOfLights.lightGreen();
                        System.out.println("2Green");
                    }
                }
            });
        }
    }

}
