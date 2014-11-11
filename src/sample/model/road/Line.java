package sample.model.road;

import sample.model.enums.LineDirection;
import sample.model.enums.RoadOrientation;
import sample.model.trafficLights.DriverLight;
import sample.model.trafficLights.TrafficLight;


public class Line implements Comparable<Line> {


    private TrafficLight trafficLight;
    private RoadOrientation orientation;
    private LineDirection direction;


    public Line(LineDirection direction, RoadOrientation orientation) {
        this.direction = direction;
        this.orientation = orientation;
        trafficLight = new DriverLight();
    }

    /*public Line(){

	}*/

    public void addConflictLight(TrafficLight light) {
        trafficLight.addConflictLight(light);
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }
    public int getCarCount() {
        return trafficLight.getDetector().getUnitCounts();
    }

    @Override
    public String toString() {
        return "Line: Direction:" + direction + ", Road orientation:" + orientation;
    }

    public RoadOrientation getOrientation() {
        return orientation;
    }

    public LineDirection getDirection() {
        return direction;
    }

    @Override
    public int compareTo(Line l) {
        if (this.getDirection() == LineDirection.TO_LEFT)
            return -1;
        else if (this.getDirection() == LineDirection.TO_RIGHT)
            return 1;
        else if (this.getDirection() == LineDirection.STRAIGHT && l.getDirection() == LineDirection.STRAIGHT)
            return 0;
        return 0;
    }
}