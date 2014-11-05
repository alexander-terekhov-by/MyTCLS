package sample.model;

import sample.model.enums.LineDirection;
import sample.model.enums.RoadOrientation;
import sample.model.road.Line;
import sample.model.road.Road;

import java.util.ArrayList;
import java.util.List;


public class Crossing {
    private List<Crossing> neighbourCrossings;
    private List<Road> roads;
    public Crossing(){
        roads = new ArrayList<Road>();
        roads.add(new Road(RoadOrientation.NORTH));
        roads.add(new Road(RoadOrientation.SOUTH));
    }


    public void addNewLine(LineDirection direction, RoadOrientation orientation){
        for(Road oneRoad : roads) {
            if (oneRoad.getOrientation() == orientation) {
                oneRoad.addNewLine(direction);
            }
        }
    }

    public void addRoad(Road road){
        for (Road crossingRoad : roads) {
            if (crossingRoad.getOrientation() == road.getOrientation()) {
                System.out.println("Дублирование дороги");
                return;
            }
        }
        roads.add(road);
    }
    public List<Road> getAllRoads(){return null;}

    @Override
    public String toString() {
        String crossingStr = "";
        for (Road oneRoad : roads)
            crossingStr += oneRoad.toString() + "\n";
        return crossingStr;
    }
}