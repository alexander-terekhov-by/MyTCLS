package sample.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Created by Александр on 08.11.2014.
 */
public class DrawerTrafficLightView extends HBox{
    ImageView light;
    Image redLight;
    Image greenLight;
    Image redAndYellowLight;
    Image yellowLight;
    DrawerTrafficLightView(){
        light = new ImageView();
        this.getChildren().add(light);
        String resourceFolder =  DrawerTrafficLightView.class.getResource("../../img/small").toString();
        redLight = new Image(resourceFolder + "/red.png");
        greenLight = new Image(resourceFolder + "/green.png");
        redAndYellowLight = new Image(resourceFolder + "/red_yellow.png");
        yellowLight  = new Image(resourceFolder + "/yellow.png");

    }

    public void lightGreen(){
        light.setImage(redAndYellowLight);
        light.setImage(greenLight);
    }

    public void lightRed(){
        light.setImage(yellowLight);
        light.setImage(redLight);
    }
}
