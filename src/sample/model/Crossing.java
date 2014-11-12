package sample.model;

import sample.model.enums.LineDirection;
import sample.model.enums.RoadOrientation;
import sample.model.road.Road;

import java.util.ArrayList;
import java.util.List;


public class Crossing {
    //private List<Crossing> neighbourCrossings;
    private List<Road> roads;

    public Crossing() {
        roads = new ArrayList<Road>();
        roads.add(new Road(RoadOrientation.NORTH));
        roads.add(new Road(RoadOrientation.SOUTH));
    }


    public void addNewCrosswalk(RoadOrientation orientation) {
        for (Road oneRoad : roads) {
            if (oneRoad.getOrientation() == orientation) {
                oneRoad.addCrosswalk();
            }
        }
    }

    public void addNewLine(LineDirection direction, RoadOrientation orientation) {
        for (Road oneRoad : roads) {
            if (oneRoad.getOrientation() == orientation) {
                oneRoad.addNewLine(direction);
            }
        }
    }

    public void addNewRoad(RoadOrientation orientation) {
        for (Road crossingRoad : roads) {
            if (crossingRoad.getOrientation() == orientation) {
                System.out.println("Дублирование дороги");
                return;
            }
        }
        roads.add(new Road(orientation));
    }

    public List<Road> getAllRoads() {
        return roads;
    }
    public Road getRoadByOrientation(RoadOrientation orientation) {
        List<Road> res = new ArrayList<Road>();
        for(Road road: roads) {
            if (road.getOrientation() == orientation)
                return road;
        }
        return  null;
    }

    @Override
    public String toString() {
        String crossingStr = "";
        for (Road oneRoad : roads)
            crossingStr += oneRoad.toString() + "\n";
        return crossingStr;
    }

    public int getMaxNumberOfLinesFromOrientation(RoadOrientation orientation) {
        for (Road road : roads) {
            if (road.getOrientation() == orientation) {
                return road.getLines().size();
            }
        }
        return 0;
    }
    public List<String> getRoadOrientations(){
        List<String> list  = new ArrayList<String>();
        for (Road road : roads)
            list.add(road.getOrientation().toString());
        return list;
    }
}