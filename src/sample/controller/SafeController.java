package sample.controller;

import sample.model.Crossing;
import sample.view.drawers.CrossingDrawer;


public class SafeController extends CrossingController {

    public SafeController(Crossing controlledCrossing, CrossingDrawer drawer) {
        super(controlledCrossing, drawer);
    }


    public void makeQueue() {

    }

    @Override
    public void setConflictedLightsToAllLights() {

    }

    public void playCrossing() {

    }

    public void useDetector() {

    }

    @Override
    public void makeGroupOfLights() {

    }


}