package sample.view.dialogs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.controller.CrossingController;
import sample.model.Crossing;
import sample.model.enums.RoadOrientation;
import sample.view.drawers.CrossingDrawer;

/**
 * Created by Александр on 10.11.2014.
 */
public class AddRoadDialog {
    Stage primaryStage;
    public AddRoadDialog(final CrossingController crossingController) {
        primaryStage = new Stage();
        VBox root = new VBox();
        VBox pane = new VBox();
        Label label = new Label("Choose road orientation:");
        primaryStage.setResizable(false);
        primaryStage.setTitle("Add road");
        Button add = new Button("Add");
        ObservableList<String> orientation = FXCollections.observableArrayList(crossingController.getRoadOrientations());
        ChoiceBox chooseOrientation = new ChoiceBox<String>(orientation);
        pane.getChildren().addAll(label, chooseOrientation, add);
        root.getChildren().add(pane);
        pane.setSpacing(5);
        root.setMargin(pane, new Insets(10, 10, 10, 10));
        primaryStage.setScene(new Scene(root, 300, 150));
        primaryStage.show();

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                crossingController.addNewRoad(RoadOrientation.EAST);
                crossingController.drawCrossing();
                AddRoadDialog.this.primaryStage.close();
            }
        });


    }
}