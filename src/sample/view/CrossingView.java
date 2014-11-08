package sample.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

/**
 * Created by Александр on 07.11.2014.
 */
public class CrossingView extends Pane {
    private Canvas canvas;


    public CrossingView() {
        canvas = new Canvas(600, 600);

        this.getChildren().add(canvas);

    }


    public Canvas getCanvas() {
        return canvas;
    }

}

