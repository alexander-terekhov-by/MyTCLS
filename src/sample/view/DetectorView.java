package sample.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.model.Detector;


/**
 * Created by Александр on 10.11.2014.
 */
public class DetectorView extends VBox {
    private Button addCar;
    private Label carCounter;

    public DetectorView(boolean horizontal, final Detector detector) {
        addCar = new Button("Add");
        carCounter = new Label("20");
        carCounter.setTextFill(Color.WHITE);
        carCounter.setFont(new Font("Arial", 20));
        Pane box;
        if (horizontal) {
            box = new HBox();

        } else {
            box = new VBox();
        }
        box.getChildren().addAll(carCounter, addCar);
        this.getChildren().add(box);

        addCar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                detector.addUnit();
            }
        });
    }

    public void setText(String carCount) {
        carCounter.setText(carCount);
    }
}
