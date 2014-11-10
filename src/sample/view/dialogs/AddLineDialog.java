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
import sample.model.enums.LineDirection;
import sample.model.enums.RoadOrientation;

/**
 * Created by Александр on 10.11.2014.
 */
public class AddLineDialog {
    Stage primaryStage;
    public AddLineDialog(final CrossingController crossingController) {
        Stage primaryStage = new Stage();
        VBox root = new VBox();
        VBox pane = new VBox();
        Label label = new Label("Choose line orientation and direction:");
        primaryStage.setResizable(false);
        primaryStage.setTitle("Add line");
        Button add = new Button("Add");
        ObservableList<String> orientation = FXCollections.observableArrayList(crossingController.getRoadOrientations());
        ObservableList<String> direction = FXCollections.observableArrayList("To right","Straight","To left");
        ChoiceBox chooseOrientation = new ChoiceBox<String>(orientation);
        ChoiceBox chooseDirection = new ChoiceBox<String>(direction);
        pane.getChildren().addAll(label, chooseOrientation, chooseDirection, add);
        root.getChildren().add(pane);
        pane.setSpacing(5);
        root.setMargin(pane, new Insets(10, 10, 10, 10));
        primaryStage.setScene(new Scene(root, 300, 150));
        primaryStage.show();

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                crossingController.addNewLine( LineDirection.STRAIGHT, RoadOrientation.EAST);
                crossingController.drawCrossing();
                AddLineDialog.this.primaryStage.close();
            }
        });


    }
}
