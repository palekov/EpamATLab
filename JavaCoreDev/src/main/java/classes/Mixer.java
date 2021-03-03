package main.java.classes;

import main.java.ElectricalDevice;
import main.java.interfaces.Switchable;

public class Mixer extends ElectricalDevice implements Switchable {

    public Mixer(String model, String color, int power) {
        super(model, color, power);
    }

    public Mixer(String model, int power) {
        super(model, power);
    }

    public Mixer() {

    }

    @Override
    public void setMode() {

    }
}
