package sample.view.drawers;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
                markLine(line,firstX + 10, firstY -7 );
                break;
            case SOUTH:
                drawLine(firstX, firstY, DrawingConstants.LINE_WIDTH, DrawingConstants.LINE_HEIGHT);
                markLine(line,firstX + 10, firstY + 10 );
                break;
            case WEST:
                drawLine(firstX - DrawingConstants.LINE_HEIGHT, firstY, DrawingConstants.LINE_HEIGHT, DrawingConstants.LINE_WIDTH);
                markLine(line,firstX - 43, firstY + 15 );
                break;
            case EAST:
                drawLine(firstX, firstY, DrawingConstants.LINE_HEIGHT, DrawingConstants.LINE_WIDTH);
                markLine(line,firstX + 5, firstY + 15 );
                break;
        }        //gc.strokeLine(,,,);
    }

    private void drawLine(int firstX, int firstY, int w, int h){
        gc.setStroke(Color.WHITE);
        gc.setLineWidth(3);
        gc.fillRect( firstX, firstY,  w, h);
        gc.strokeRect( firstX, firstY,  w, h);
    }


    private void markLine(Line line, int x, int y){
        gc.setLineWidth(1);
        gc.setFont(new Font("Arial", 8));
        switch(line.getDirection())
        {
            case TO_RIGHT:
                gc.strokeText("RIGHT", x, y, DrawingConstants.LINE_WIDTH - 5);
                break;
            case TO_LEFT:
                gc.strokeText("LEFT", x, y, DrawingConstants.LINE_WIDTH - 5);
                break;
            case STRAIGHT:
                gc.strokeText("STRAIGHT", x, y, DrawingConstants.LINE_WIDTH - 5);
                break;


        }
    }
}