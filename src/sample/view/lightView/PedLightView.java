package sample.view.lightView;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Created by Александр on 09.11.2014.
 */
public class PedLightView extends HBox implements LightView {
    ImageView light;
    Image redLight;
    Image greenLight;

    public PedLightView() {

        String resourceFolder = DriverLightView.class.getResource("../../../img/small_people").toString();
        redLight = new Image(resourceFolder + "/red.png");
        greenLight = new Image(resourceFolder + "/green.png");
        light = new ImageView(redLight);
        this.getChildren().add(light);
    }

    @Override
    public void lightGreen() {
        light.setImage(greenLight);
    }

    @Override
    public void lightRed() {
        light.setImage(redLight);
    }

    @Override
    public void lightYellow() {

    }

    @Override
    public void lightYellowAndRed() {

    }


}

