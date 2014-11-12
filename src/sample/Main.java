package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.controller.CrossingController;
import sample.controller.OrdinaryController;
import sample.model.Crossing;
import sample.view.CrossingView;
import sample.view.dialogs.AddCrosswalkDialog;
import sample.view.dialogs.AddLineDialog;
import sample.view.dialogs.AddRoadDialog;
import sample.view.dialogs.LoadCrossingDialog;
import sample.view.drawers.CrossingDrawer;

import java.util.List;

public class Main extends Application {
    CrossingController controller;
    CrossingView crossingView;
    List<Crossing> crossingTemplates;

    private void makeCrossingTemplates() {
        crossingTemplates.add(CrossingsFactory.makeFullFourRoadCrossing());
        crossingTemplates.add(CrossingsFactory.makeFullThreeRoadCrossing());
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Trafficlight control system");
        crossingView = new CrossingView();
        root.setCenter(crossingView);
        root.setRight(new ButtonBar());
        primaryStage.setScene(new Scene(root, 710, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


    private class ButtonBar extends VBox {
        ButtonBar() {
            VBox innerBox = new VBox();
            innerBox.setSpacing(5);
            Button newCrossing = new Button("Create crossing");
            Button loadCrossing = new Button("Load crossing");
            Button playButton = new Button("Start");
            Button stop = new Button("Stop");
            Button addRoad = new Button("Add road");
            Button addLine = new Button("Add line");
            Button addCrosswalk = new Button("Add crosswalk");


            innerBox.getChildren().addAll(newCrossing, loadCrossing, playButton, stop, addRoad, addLine, addCrosswalk);
            setButtonSize(innerBox.getChildren());
            this.setMargin(innerBox, new Insets(10, 10, 10, 10));
            this.getChildren().add(innerBox);

            playButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    controller.playCrossing();

                }
            });
            stop.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    controller.stop();

                }
            });
            addRoad.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    new AddRoadDialog(controller);

                }
            });
            addLine.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    new AddLineDialog(controller);

                }
            });
            addCrosswalk.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    new AddCrosswalkDialog(controller);

                }
            });
            newCrossing.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    CrossingDrawer drawer = new CrossingDrawer(crossingView);
                    controller = new OrdinaryController(CrossingsFactory.makeStarterCrossing(), drawer);
                    controller.makeGroupOfLights();
                    controller.drawCrossing();
                }

            });
            loadCrossing.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                   CrossingDrawer drawer = new CrossingDrawer(crossingView);
                   controller = new OrdinaryController(null, drawer);
                   new LoadCrossingDialog(controller);
                }

            });
        }

        private void setButtonSize(ObservableList<Node> buttons) {
            for (Node button : buttons) {
                ((Button) button).setPrefWidth(100);
                ((Button) button).setPrefHeight(25);
            }
        }
    }
}


