package sample.view.dialogs;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import sample.CrossingsFactory;
import sample.controller.CrossingController;
import sample.controller.OrdinaryController;
import sample.model.enums.RoadOrientation;
import sample.view.drawers.CrossingDrawer;

/**
 * Created by Александр on 12.11.2014.
 */
public class LoadCrossingDialog {
    Stage primaryStage;
    public LoadCrossingDialog(final CrossingController crossingController) {
        primaryStage = new Stage();
        VBox root = new VBox();
        VBox pane = new VBox();
        Label label = new Label("Choose variant of crossing:");
        primaryStage.setResizable(false);
        primaryStage.setTitle("Choose crossing");
        Button set = new Button("Add");
        ObservableList<String> orientation = FXCollections.observableArrayList("Full crossing with four roads", "Full crossing with three roads");
        ChoiceBox chooser = new ChoiceBox<String>(orientation);
        pane.getChildren().addAll(label, chooser, set);
        root.getChildren().add(pane);
        pane.setSpacing(5);
        root.setMargin(pane, new Insets(10, 10, 10, 10));
        primaryStage.setScene(new Scene(root, 300, 150));
        primaryStage.show();

        set.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoadCrossingDialog.this.primaryStage.close();
                crossingController .makeGroupOfLights();
                crossingController .drawCrossing();
            }
        });

        chooser.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
        {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
            {
                if (newValue.equals("Full crossing with four roads"))
                {
                    crossingController.setCrossing(CrossingsFactory.makeFullFourRoadCrossing());

                }

                if (newValue.equals("Full crossing with three roads"))
                {
                    crossingController.setCrossing(CrossingsFactory.makeFullThreeRoadCrossing());
                }
            }
        });


    }
}

