package sample.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Created by Александр on 08.11.2014.
 */
public class DriverLightView extends HBox {
    ImageView light;
    Image redLight;
    Image greenLight;
    Image redAndYellowLight;
    Image yellowLight;

    public DriverLightView() {

        String resourceFolder = DriverLightView.class.getResource("../../img/small").toString();
        redLight = new Image(resourceFolder + "/red.png");
        greenLight = new Image(resourceFolder + "/green.png");
        redAndYellowLight = new Image(resourceFolder + "/red_yellow.png");
        yellowLight = new Image(resourceFolder + "/yellow.png");
        light = new ImageView(redLight);
        this.getChildren().add(light);
    }

    public void lightGreen() {
        light.setImage(redAndYellowLight);
        light.setImage(greenLight);
    }

    public void lightRed() {
        light.setImage(yellowLight);
        light.setImage(redLight);
    }
}
