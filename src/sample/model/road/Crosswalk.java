package sample.model.road;


import sample.model.trafficLights.PedLight;
import sample.view.lightView.PedLightView;

public class Crosswalk {

	private PedLight pedLight;


	public Crosswalk(){
        pedLight = new PedLight();
	}
    public PedLight getPedLight() {
        return pedLight;
    }
}