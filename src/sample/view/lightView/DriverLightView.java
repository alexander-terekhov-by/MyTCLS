package sample.view.lightView;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Created by Александр on 08.11.2014.
 */
public class DriverLightView extends HBox implements LightView {
    ImageView light;
    Image redLight;
    Image greenLight;
    Image redAndYellowLight;
    Image yellowLight;

    public DriverLightView() {
        String resourceFolder = DriverLightView.class.getResource("../../../img/small").toString();
        redLight = new Image(resourceFolder + "/red.png");
        greenLight = new Image(resourceFolder + "/green.png");
        redAndYellowLight = new Image(resourceFolder + "/red_yellow.png");
        yellowLight = new Image(resourceFolder + "/yellow.png");
        light = new ImageView(redLight);
        this.getChildren().add(light);  // test commit
    }

    public void lightGreen() {
        //add countDownTimer or timer or sleep
        light.setImage(greenLight);
    }

    public void lightRed() {
        //add countDownTimer or timer or sleep
        light.setImage(redLight);
    }

    @Override
    public void lightYellow() {
        light.setImage(yellowLight);
    }

    @Override
    public void lightYellowAndRed() {
        light.setImage(redAndYellowLight);
    }
}
