package sample.view.drawers;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sample.model.Crossing;
import sample.model.enums.RoadOrientation;
import sample.model.road.Road;
import sample.view.CrossingView;

/**
 * Created by Александр on 07.11.2014.
 */
public class CrossingDrawer {
    CrossingView crossingView;

    public CrossingDrawer(CrossingView crossingView) {
        this.crossingView = crossingView;
    }

    public void drawCrossing(Crossing crossing) {
        crossingView.prepareToDrawCrossing();
        Canvas canvas = crossingView.getCanvas();
        RoadDrawer roadDrawer = new RoadDrawer(crossingView);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTGREEN);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int w = Math.max(crossing.getMaxNumberOfLinesFromOrientation(RoadOrientation.NORTH),
                crossing.getMaxNumberOfLinesFromOrientation(RoadOrientation.SOUTH)) * DrawingConstants.LINE_WIDTH;
        int h = Math.max(crossing.getMaxNumberOfLinesFromOrientation(RoadOrientation.WEST),
                crossing.getMaxNumberOfLinesFromOrientation(RoadOrientation.EAST)) * DrawingConstants.LINE_WIDTH;
        gc.setFill(Color.GRAY);
        int firstPos = 190;
        gc.fillRect(firstPos, firstPos, w, h);
        for (Road road : crossing.getAllRoads()) {
            if (road.getOrientation() == RoadOrientation.NORTH || road.getOrientation() == RoadOrientation.WEST) {
                roadDrawer.drawRoad(road, firstPos, firstPos);
            } else {
                if (road.getOrientation() == RoadOrientation.SOUTH) {
                    roadDrawer.drawRoad(road, firstPos, firstPos + h);
                } else {
                    if (road.getOrientation() == RoadOrientation.EAST) {
                        roadDrawer.drawRoad(road, firstPos + w, firstPos);
                    }
                }
            }
        }
    }
}
