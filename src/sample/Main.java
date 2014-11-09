package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import sample.model.trafficLights.DriverLight;
import sample.model.trafficLights.PedLight;
import sample.model.trafficLights.TrafficLight;
import sample.view.CrossingView;
import sample.view.lightView.DriverLightView;
import sample.view.drawers.CrossingDrawer;
import sample.view.lightView.PedLightView;

public class Main extends Application {
    CrossingDrawer crDrTest;
    DriverLightView light;
    DriverLightView light1;
    boolean green = false;

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();
        primaryStage.setResizable(false);
        primaryStage.setTitle("TCLS");
        CrossingView crossingView = new CrossingView();

        root.setCenter(crossingView);
        root.setRight(new ButtonBar());
        primaryStage.setScene(new Scene(root, 700, 600));
        crDrTest = new CrossingDrawer(crossingView);
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
        Crossing testCr = new Crossing();
        testCr.addNewLine(LineDirection.TO_RIGHT, RoadOrientation.NORTH);
        testCr.addNewRoad(RoadOrientation.WEST);
        testCr.addNewRoad(RoadOrientation.EAST);
        testCr.addNewCrosswalk(RoadOrientation.WEST);
        testCr.addNewCrosswalk(RoadOrientation.NORTH);
        testCr.addNewCrosswalk(RoadOrientation.SOUTH);
        testCr.addNewCrosswalk(RoadOrientation.EAST);
        testCr.addNewLine(LineDirection.TO_LEFT, RoadOrientation.SOUTH);
        testCr.addNewLine(LineDirection.TO_RIGHT, RoadOrientation.WEST);
        testCr.addNewLine(LineDirection.TO_LEFT, RoadOrientation.EAST);
        CrossingController controllerTest = new OrdinaryController(testCr);
        controllerTest.makeGroupOfLights();
        //System.out.println(controllerTest.toString());
        crDrTest.drawCrossing(testCr);
        controllerTest.playCrossing();
        /*for(Road road : testCr.getAllRoads())
            for(Line line : road.getLines())
            line.printConflict();*/


        System.out.println(testCr);
    }
    private class ButtonBar extends VBox{
        ButtonBar(){
            VBox innerBox = new VBox();
            innerBox.setSpacing(5);
            Button playButton = new Button("StartCrossing");

            innerBox.getChildren().add(playButton);

            //this.setAlignment(Pos.BASELINE_CENTER);
            this.setMargin(innerBox, new Insets(10,10,10,10));
            this.getChildren().add(innerBox);



            playButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    /*if(!green) {
                        light1.lightGreen();
                        light1.lightGreen();
                        green = true;
                    }
                    else {
                        light.lightRed();
                        light.lightRed();
                        green = false;
                    }*/
                }
            });
        }
    }


}
