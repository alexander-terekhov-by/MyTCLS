package sample.model.road;

import sample.model.enums.LineDirection;
import sample.model.enums.RoadOrientation;
import sample.model.trafficLights.PedLight;

import java.util.ArrayList;
import java.util.List;


public class Road {

	private List<Line> lines;
    private Crosswalk crosswalk;
    private RoadOrientation orientation;


    public Road(RoadOrientation orientation){
        this.orientation = orientation;
        lines = new ArrayList<Line>();
        addNewLine(LineDirection.STRAIGHT);
	}
    public void addNewLine(LineDirection direction){
        lines.add(new Line( direction, orientation));
    }
    public List<Line> getLines() {
        return lines;
    }
    public RoadOrientation getOrientation() {
        return orientation;
    }
    public boolean isOppositeRoad(Road road){
        return  ((orientation == RoadOrientation.NORTH && road.getOrientation() == RoadOrientation.SOUTH)
                ||
                (orientation == RoadOrientation.WEST && road.getOrientation() == RoadOrientation.EAST)
                ||
                (orientation == RoadOrientation.SOUTH && road.getOrientation() == RoadOrientation.NORTH)
                ||
                (orientation == RoadOrientation.EAST && road.getOrientation() == RoadOrientation.WEST));
    }
    public boolean haveCrosswalk(){
        return crosswalk != null;
    }
    public Crosswalk getCrosswalk(){
        return crosswalk;
    }
    public void addCrosswalk(){
        crosswalk = new Crosswalk();
    }



}