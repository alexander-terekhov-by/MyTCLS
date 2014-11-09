package sample.view.drawers;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sample.model.enums.RoadOrientation;
import sample.model.road.Line;
import sample.model.road.Road;
import sample.view.CrossingView;
import sample.view.lightView.DriverLightView;
import sample.view.lightView.PedLightView;

/**
 * Created by Александр on 08.11.2014.
 */
public class RoadDrawer {
    GraphicsContext gc;
    LineDrawer lineDrawer;
    CrossingView crossingView;
    public RoadDrawer(CrossingView crossingView) {
        this.crossingView = crossingView;
        Canvas canvas =  crossingView.getCanvas();
        gc = canvas.getGraphicsContext2D();
        lineDrawer = new LineDrawer(crossingView);
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
            int yPosForPedLight = 0;
            gc.setFill(Color.WHITE);
            for(int i = firstX; i < nextX; i+= DrawingConstants.ZEBRA_WIDTH + 3) {
                if (road.getOrientation() == RoadOrientation.SOUTH) {
                    gc.fillRect(i, firstY + DrawingConstants.ZEBRA_ALIGN, DrawingConstants.ZEBRA_WIDTH, DrawingConstants.ZEBRA_HEIGHT);
                    yPosForPedLight = firstY + DrawingConstants.ZEBRA_ALIGN;
                } else {
                    gc.fillRect(i, firstY - DrawingConstants.ZEBRA_ALIGN - DrawingConstants.ZEBRA_HEIGHT, DrawingConstants.ZEBRA_WIDTH, DrawingConstants.ZEBRA_HEIGHT);
                    yPosForPedLight = firstY - DrawingConstants.ZEBRA_ALIGN - 17;
                }
            }
            addPedLights(road, firstX - 15,yPosForPedLight + 10);
            addPedLights(road, nextX + 5, yPosForPedLight - 10);
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
            int  xPosForPedLight;
            gc.setFill(Color.WHITE);
            for(int i = firstY; i < nextY; i += DrawingConstants.ZEBRA_WIDTH + 3 ) {
                if (road.getOrientation() == RoadOrientation.WEST) {
                    gc.fillRect(firstX - DrawingConstants.ZEBRA_ALIGN - DrawingConstants.ZEBRA_HEIGHT, i, DrawingConstants.ZEBRA_HEIGHT, DrawingConstants.ZEBRA_WIDTH);
                    xPosForPedLight =  firstX - DrawingConstants.ZEBRA_ALIGN - DrawingConstants.ZEBRA_HEIGHT;
                }
                else {
                    gc.fillRect(firstX + DrawingConstants.ZEBRA_ALIGN, i, DrawingConstants.ZEBRA_HEIGHT, DrawingConstants.ZEBRA_WIDTH);
                    xPosForPedLight =  firstX + DrawingConstants.ZEBRA_ALIGN;
                }
                addPedLights(road, xPosForPedLight - 5, firstY - 25);
                addPedLights(road, xPosForPedLight + 15, nextY + 5);
            }
        }
    }
    private void addPedLights(Road road, int x, int y){
        PedLightView pedLightView = new PedLightView();
        road.getCrosswalk().getPedLight().addView(pedLightView);
        crossingView.getChildren().add(pedLightView);
        pedLightView.setLayoutX(x);
        pedLightView.setLayoutY(y);
    }
}





