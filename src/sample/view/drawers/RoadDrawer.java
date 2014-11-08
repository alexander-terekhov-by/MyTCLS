package sample.view.drawers;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sample.model.enums.RoadOrientation;
import sample.model.road.Line;
import sample.model.road.Road;

/**
 * Created by Александр on 08.11.2014.
 */
public class RoadDrawer {
    GraphicsContext gc;
    LineDrawer lineDrawer;



    public RoadDrawer(Canvas canvas) {
        gc = canvas.getGraphicsContext2D();
        lineDrawer = new LineDrawer(canvas);
    }

    public void drawRoad(Road road, int firstX, int firstY) {
        switch (road.getOrientation()) {
            case NORTH:
            case SOUTH:
                drawVerticalLines(road, firstX, firstY);
                break;
            case WEST:
            case EAST:
                drawHorizontalLines(road, firstX, firstY);
                break;
        }


        //gc.strokeLine(,,,);
    }

    private void drawVerticalLines(Road road, int firstX, int firstY){
        int nextX = firstX;
        //System.out.println("x= " + nextX);
        for (Line line: road.getLines()){
            lineDrawer.drawLine(line, nextX, firstY );
            nextX += DrawingConstants.LINE_WIDTH;
        }
        if (road.haveCrosswalk()){
            gc.setFill(Color.WHITE);
            for(int i = firstX; i < nextX; i+= DrawingConstants.ZEBRA_WIDTH + 3) {
                if (road.getOrientation() == RoadOrientation.SOUTH)
                    gc.fillRect(i, firstY + DrawingConstants.ZEBRA_ALIGN, DrawingConstants.ZEBRA_WIDTH, DrawingConstants.ZEBRA_HEIGHT);
                else
                    gc.fillRect(i, firstY - DrawingConstants.ZEBRA_ALIGN - DrawingConstants.ZEBRA_WIDTH,  DrawingConstants.ZEBRA_WIDTH, DrawingConstants.ZEBRA_HEIGHT);

            }
        }
    }
    private void drawHorizontalLines(Road road, int firstX, int firstY){
        int nextY = firstY;
        for (Line line: road.getLines()){
            //System.out.println(nextY);
            lineDrawer.drawLine(line, firstX, nextY);
            nextY += DrawingConstants.LINE_WIDTH;
        }
        if (road.haveCrosswalk()){
            gc.setFill(Color.WHITE);
            for(int i = firstY; i < nextY; i += DrawingConstants.ZEBRA_WIDTH + 3 ) {
                if (road.getOrientation() == RoadOrientation.WEST)
                    gc.fillRect(firstX - DrawingConstants.ZEBRA_ALIGN - DrawingConstants.ZEBRA_HEIGHT, i, DrawingConstants.ZEBRA_HEIGHT, DrawingConstants.ZEBRA_WIDTH);
                else
                    gc.fillRect(firstX + DrawingConstants.ZEBRA_ALIGN, i, DrawingConstants.ZEBRA_HEIGHT, DrawingConstants.ZEBRA_WIDTH);

            }
        }
    }


}
