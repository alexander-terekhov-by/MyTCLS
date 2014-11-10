package sample.model.road;


import sample.model.trafficLights.PedLight;

public class Crosswalk {

    private PedLight pedLight;


    public Crosswalk() {
        pedLight = new PedLight();
    }

    public PedLight getPedLight() {
        return pedLight;
    }
}