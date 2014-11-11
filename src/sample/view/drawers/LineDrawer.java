package sample.view.drawers;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.model.Detector;
import sample.model.road.Line;
import sample.view.CrossingView;
import sample.view.DetectorView;
import sample.view.lightView.DriverLightView;

/**
 * Created by Александр on 07.11.2014.
 */
public class LineDrawer {
    GraphicsContext gc;
    CrossingView crossingView;


    public LineDrawer(CrossingView crossingView) {
        this.crossingView = crossingView;
        Canvas canvas = crossingView.getCanvas();
        gc = canvas.getGraphicsContext2D();
    }

    public void buildLine(Line line, int firstX, int firstY) {
        gc.setFill(Color.GRAY);
        switch (line.getOrientation()) {
            case NORTH:
                drawLine(firstX, firstY - DrawingConstants.LINE_HEIGHT, DrawingConstants.LINE_WIDTH, DrawingConstants.LINE_HEIGHT);
                markLine(line, firstX + 10, firstY - 7);
                addTrafficLights(line, firstX + 25, firstY - 47);
                addDetector(line, firstX + 10, firstY - 140, false);
                break;
            case SOUTH:
                drawLine(firstX, firstY, DrawingConstants.LINE_WIDTH, DrawingConstants.LINE_HEIGHT);
                markLine(line, firstX + 10, firstY + 10);
                addTrafficLights(line, firstX + 25, firstY + 15);
                addDetector(line, firstX + 10, firstY + 100, false);
                break;
            case WEST:
                drawLine(firstX - DrawingConstants.LINE_HEIGHT, firstY, DrawingConstants.LINE_HEIGHT, DrawingConstants.LINE_WIDTH);
                markLine(line, firstX - 43, firstY + 15);
                addTrafficLights(line, firstX - 18, firstY + 20);
                addDetector(line, firstX - 140, firstY + 15, true);
                break;
            case EAST:
                drawLine(firstX, firstY, DrawingConstants.LINE_HEIGHT, DrawingConstants.LINE_WIDTH);
                markLine(line, firstX + 5, firstY + 15);
                addTrafficLights(line, firstX + 5, firstY + 20);
                addDetector(line, firstX + 90, firstY + 20, true);
                break;
        }
    }

    private void drawLine(int firstX, int firstY, int w, int h) {
        gc.setStroke(Color.WHITE);
        gc.setLineWidth(3);
        gc.fillRect(firstX, firstY, w, h);
        gc.strokeRect(firstX, firstY, w, h);
    }

    private void markLine(Line line, int x, int y) {
        gc.setLineWidth(1);
        gc.setFont(new Font("Arial", 8));
        switch (line.getDirection()) {
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

    private void addTrafficLights(Line line, int x, int y) {
        DriverLightView driverLightView = new DriverLightView();
        line.getTrafficLight().addView(driverLightView);
        crossingView.getChildren().add(driverLightView);
        driverLightView.setLayoutX(x);
        driverLightView.setLayoutY(y);
    }

    private void addDetector(Line line, int x, int y, boolean horizontal) {
        Detector detector = line.getTrafficLight().getDetector();
        DetectorView detectorView = new DetectorView(horizontal, detector);
        detector.setView(detectorView);
        crossingView.getChildren().add(detectorView);
        detectorView.setLayoutX(x);
        detectorView.setLayoutY(y);
    }
}
