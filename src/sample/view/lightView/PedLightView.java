package sample.view.lightView;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import sample.view.lightView.DriverLightView;

/**
 * Created by Александр on 09.11.2014.
 */
public class PedLightView extends HBox {
    ImageView light;
    Image redLight;
    Image greenLight;
    public PedLightView(){

        String resourceFolder =  DriverLightView.class.getResource("../../../img/small_people").toString();
        redLight = new Image(resourceFolder + "/red.png");
        greenLight = new Image(resourceFolder + "/green.png");
        light = new ImageView(redLight);
        this.getChildren().add(light);
    }

    public void lightGreen(){
        light.setImage(greenLight);
    }

    public void lightRed(){
        light.setImage(redLight);
    }
}

