package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.controller.CrossingController;
import sample.controller.OrdinaryController;
import sample.model.Crossing;
import sample.model.enums.LineDirection;
import sample.model.enums.RoadOrientation;
import sample.view.CrossingView;
import sample.view.dialogs.AddCrosswalkDialog;
import sample.view.dialogs.AddLineDialog;
import sample.view.dialogs.AddRoadDialog;
import sample.view.drawers.CrossingDrawer;
import sample.view.lightView.DriverLightView;

public class Main extends Application {
    CrossingController controller;
    CrossingView crossingView;


    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();
        primaryStage.setResizable(false);
        primaryStage.setTitle("TCLS");
        crossingView = new CrossingView();

        root.setCenter(crossingView);
        root.setRight(new ButtonBar());
        primaryStage.setScene(new Scene(root, 700, 600));

        //light = new DriverLightView();
        //light1 = new DriverLightView();
        // root.setCenter(light);
        // root.setTop(light1);

        testDrawingCrossing();
        primaryStage.show();



        /*DriverLightView test1 = new DriverLightView();
        PedLightView test2 =  new PedLightView();
        final TrafficLight trafficLight = new TrafficLight();
        trafficLight.addView(test1);

        Button btn = new Button("Test");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                trafficLight.lightGreen();
            }
        });
        root.getChildren().add(test1);
        root.setCenter(btn);*/


    }


    public static void main(String[] args) {


        launch(args);


    }

    public void testDrawingCrossing() {
        Crossing crossing = new Crossing();
        //crossing.addNewLine(LineDirection.TO_RIGHT, RoadOrientation.NORTH);
        //crossing.addNewRoad(RoadOrientation.WEST);
        //crossing.addNewRoad(RoadOrientation.EAST);
        //crossing.addNewCrosswalk(RoadOrientation.WEST);
        //crossing.addNewCrosswalk(RoadOrientation.NORTH);
        //crossing.addNewCrosswalk(RoadOrientation.SOUTH);
        //crossing.addNewCrosswalk(RoadOrientation.EAST);
        //crossing.addNewLine(LineDirection.TO_LEFT, RoadOrientation.SOUTH);
        //crossing.addNewLine(LineDirection.TO_RIGHT, RoadOrientation.WEST);
        //crossing.addNewLine(LineDirection.TO_LEFT, RoadOrientation.EAST);
        CrossingDrawer drawer = new CrossingDrawer(crossingView);
        controller = new OrdinaryController(crossing, drawer);
        controller.makeGroupOfLights();
        controller.drawCrossing();
        //System.out.println(controllerTest.toString());
        ///controller.playCrossing();
        /*for(Road road : crossing.getAllRoads())
            for(Line line : road.getLines())
            line.printConflict();*/


        //System.out.println(crossing);
    }

    private class ButtonBar extends VBox {
        ButtonBar() {
            VBox innerBox = new VBox();
            innerBox.setSpacing(5);
            Button playButton = new Button("StartCrossing");
            Button addRoad = new Button("Add road");
            Button addLine = new Button("Add line");
            Button addCrosswalk = new Button("Add crosswalk");

            innerBox.getChildren().addAll(playButton, addRoad, addLine, addCrosswalk);

            //this.setAlignment(Pos.BASELINE_CENTER);
            this.setMargin(innerBox, new Insets(10, 10, 10, 10));
            this.getChildren().add(innerBox);


            playButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    controller.playCrossing();

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
        }
    }


}
