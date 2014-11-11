package sample.controller;

import sample.model.Crossing;
import sample.model.enums.LineDirection;
import sample.model.enums.RoadOrientation;
import sample.model.road.Line;
import sample.model.road.Road;
import sample.view.drawers.CrossingDrawer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class CrossingController {


    protected Crossing controlledCrossing;
    protected CrossingDrawer drawer;
    protected int sessionTime;

    public CrossingController(Crossing crossing, CrossingDrawer drawer) {
        controlledCrossing = crossing;
        this.drawer = drawer;
        sessionTime = 10;
    }

    public abstract void playCrossing();

    public void addNewCrosswalk(RoadOrientation orientation) {
        controlledCrossing.addNewCrosswalk(orientation);
        makeGroupOfLights();
    }

    public void addNewLine(LineDirection direction, RoadOrientation orientation) {
        controlledCrossing.addNewLine(direction, orientation);
        makeGroupOfLights();
    }

    public void addNewRoad(RoadOrientation orientation) {
        controlledCrossing.addNewRoad(orientation);
        makeGroupOfLights();
    }

    public List<String> getRoadOrientations() {
        return controlledCrossing.getRoadOrientations();
    }

    public List<String> getAbsentRoadOrientations() {
        List<String> allOrientations = new ArrayList<String>(Arrays.asList("NORTH", "SOUTH", "WEST", "EAST"));
        allOrientations.removeAll(getRoadOrientations());
        return allOrientations;
    }


    public void checkDetector() {
        int maxCountCarsOfVerticalRoads = 0;
        int maxCountCarsOfHorizontalRoads = 0;
        RoadOrientation orientation = null;
        for (Road road : controlledCrossing.getAllRoads()) {
            orientation = road.getOrientation();

            for (Line line : road.getLines()) {
                if (orientation == RoadOrientation.NORTH || orientation == RoadOrientation.SOUTH)
                    maxCountCarsOfVerticalRoads = Math.max(maxCountCarsOfVerticalRoads,line.getCarCount());
                else
                    maxCountCarsOfHorizontalRoads = Math.max(maxCountCarsOfHorizontalRoads,line.getCarCount());

            }
        }

    }

    public abstract void makeGroupOfLights();

    public abstract void setConflictedLightsToAllLights();

    public void setSessionTime(int sessionTime) {
        this.sessionTime = sessionTime;
    }

    public void drawCrossing() {
        drawer.drawCrossing(controlledCrossing);
    }
}