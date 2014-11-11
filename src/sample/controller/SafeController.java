package sample.controller;

import sample.model.Crossing;
import sample.view.drawers.CrossingDrawer;


public class SafeController extends CrossingController {

    public SafeController(Crossing controlledCrossing, CrossingDrawer drawer) {
        super(controlledCrossing, drawer);
    }

    public void playCrossing() {

    }



    @Override
    public void makeGroupOfLights() {

    }


}