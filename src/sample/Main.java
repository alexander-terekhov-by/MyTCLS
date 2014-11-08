package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.controller.CrossingController;
import sample.controller.OrdinaryController;
import sample.model.Crossing;
import sample.model.enums.LineDirection;
import sample.model.enums.RoadOrientation;
import sample.model.road.Line;
import sample.model.road.Road;
import sample.view.CrossingView;
import sample.view.drawers.CrossingDrawer;
import sample.view.drawers.DrawingConstants;
import sample.view.drawers.LineDrawer;

public class Main extends Application {
    CrossingDrawer crDrTest;
    @Override
    public void start(Stage primaryStage) throws Exception{

        Pane root = new BorderPane();
        primaryStage.setResizable(false);
        primaryStage.setTitle("TCLS");CrossingView crTest = new CrossingView();
        root.getChildren().add(crTest);
        primaryStage.setScene(new Scene(root, 700, 600));
        //new  LineDrawer (crTest.canvas).drawLine(null, 2,43);
        crDrTest = new CrossingDrawer(crTest.canvas);
        //testDrawingLines(crTest.canvas);
        testDrawingCrossing();
        //crDrTest.drawCrossing(new Crossing());
        primaryStage.show();
        /*Pane root = new BorderPane();
        primaryStage.setTitle("TCLS");
        CrossingView viewTest = new CrossingView();
        new LineDrawer(viewTest).drawLine( 5, 5);
        GraphicsContext gc = viewTest.getCanvas().getGraphicsContext2D();
        gc.strokeLine(20,20,56,56);
        primaryStage.setScene(new Scene(root, 300, 275));
        root.getChildren().addAll();
        root.setVisible(true);
        primaryStage.show();*/
    }


    public static void main(String[] args) {



        launch(args);


    }

    public void testDrawingCrossing(){
        Crossing testCr = new Crossing();
        testCr.addNewLine(LineDirection.TO_RIGHT, RoadOrientation.NORTH);
        testCr.addNewLine(LineDirection.TO_RIGHT, RoadOrientation.NORTH);
        //testCr.addNewRoad(RoadOrientation.NORTH);
        testCr.addNewRoad(RoadOrientation.WEST);
        testCr.addNewRoad(RoadOrientation.EAST);
        testCr.addNewCrosswalk(RoadOrientation.WEST);
        testCr.addNewCrosswalk(RoadOrientation.NORTH);
        testCr.addNewCrosswalk(RoadOrientation.SOUTH);
        testCr.addNewCrosswalk(RoadOrientation.EAST);
        testCr.addNewLine(LineDirection.TO_RIGHT, RoadOrientation.WEST);
        CrossingController controllerTest = new OrdinaryController(testCr);
        controllerTest.makeGroupOfLights();
        //System.out.println(controllerTest.toString());
        //controllerTest.playCrossing();
        crDrTest.drawCrossing(testCr);
        /*for(Road road : testCr.getAllRoads())
            for(Line line : road.getLines())
            line.printConflict();*/


        System.out.println(testCr);
    }

}
