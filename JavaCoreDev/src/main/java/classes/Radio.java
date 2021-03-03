package main.java.classes;

import main.java.ElectricalDevice;
import main.java.interfaces.Tuneable;

public class Radio extends ElectricalDevice implements Tuneable {
    public Radio(String model, String color, int power) {
        super(model, color, power);
    }

    public Radio() {

    }

    @Override
    public void setVolume() {

    }

    @Override
    public void setChannel() {

    }
}
