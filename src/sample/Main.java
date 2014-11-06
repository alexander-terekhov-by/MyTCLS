package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.controller.CrossingController;
import sample.controller.OrdinaryController;
import sample.model.Crossing;
import sample.model.enums.LineDirection;
import sample.model.enums.RoadOrientation;
import sample.model.road.Line;
import sample.model.road.Road;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = new BorderPane();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Crossing testCr = new Crossing();
        testCr.addNewLine(LineDirection.TO_RIGHT, RoadOrientation.NORTH);
        //testCr.addNewRoad(RoadOrientation.NORTH);
        testCr.addNewRoad(RoadOrientation.WEST);
        testCr.addNewCrosswalk(RoadOrientation.WEST);
        CrossingController controllerTest = new OrdinaryController(testCr);
        controllerTest.makeGroupOfLights();
        System.out.println(controllerTest.toString());
        /*for(Road road : testCr.getAllRoads())
            for(Line line : road.getLines())
            line.printConflict();*/


        //System.out.println(testCr);


        //launch(args);
    }
}
