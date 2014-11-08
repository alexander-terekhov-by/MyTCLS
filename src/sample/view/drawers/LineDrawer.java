package sample.view.drawers;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sample.model.road.Line;

/**
 * Created by Александр on 07.11.2014.
 */
public class LineDrawer {
    GraphicsContext gc;


    public LineDrawer(Canvas canvas) {
        gc = canvas.getGraphicsContext2D();
    }

    public void drawLine(Line line, int firstX, int firstY) {
        // System.out.println("Line dravw");
        gc.setFill(Color.GRAY);
        //gc.setStroke(Color.RED);
        switch (line.getOrientation()) {
            case NORTH:
                drawLine(firstX, firstY - DrawingConstants.LINE_HEIGHT, DrawingConstants.LINE_WIDTH, DrawingConstants.LINE_HEIGHT);
                break;
            case SOUTH:
                drawLine(firstX, firstY, DrawingConstants.LINE_WIDTH, DrawingConstants.LINE_HEIGHT);
                break;
            case WEST:
                drawLine(firstX - DrawingConstants.LINE_HEIGHT, firstY, DrawingConstants.LINE_HEIGHT, DrawingConstants.LINE_WIDTH);
                break;
            case EAST:
                drawLine(firstX, firstY, DrawingConstants.LINE_HEIGHT, DrawingConstants.LINE_WIDTH);
                break;
        }        //gc.strokeLine(,,,);
    }

    private void drawLine(int firstX, int firstY, int w, int h){
        gc.setStroke(Color.WHITE);
        gc.setLineWidth(3);
        gc.fillRect( firstX, firstY,  w, h);
        gc.strokeRect( firstX, firstY,  w, h);

    }
}
