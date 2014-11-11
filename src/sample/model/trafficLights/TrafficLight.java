package sample.model.trafficLights;

import sample.model.Detector;
import sample.view.lightView.LightView;

import java.util.ArrayList;
import java.util.List;


public class TrafficLight {

    private List<TrafficLight> conflictLights;
    List<LightView> views;
    private Detector detector;


    public TrafficLight() {
        conflictLights = new ArrayList<TrafficLight>();
        views = new ArrayList<LightView>();
        detector = new Detector();
    }

    public Detector getDetector() {
        return detector;
    }


    public void addView(LightView view) {
        this.views.add(view);
    }

    public void lightGreen() {
        //detector.skipUnit();
        for (LightView view : views)
            view.lightGreen();
    }

    public void lightRed() {
        for (LightView view : views)
            view.lightRed();
    }

    public void lightYellow() {
        for (LightView view : views)
            view.lightYellow();
    }
    public void lightYellowAndRed() {
        for (LightView view : views)
            view.lightYellowAndRed();
    }

    public void addConflictLight(TrafficLight light) {
        conflictLights.add(light);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void printConflicts() {
        //for (TrafficLight light : conflictLights)
            //System.out.println(light.toString());
    }
}