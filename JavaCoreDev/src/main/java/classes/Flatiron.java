package main.java.classes;

import main.java.ElectricalDevice;
import main.java.interfaces.Switchable;

public class Flatiron extends ElectricalDevice implements Switchable {

    public Flatiron(String model, String color, int power) {
        super(model, color, power);
    }

    public Flatiron(String model, int power) {
        super(model, power);
    }

    public Flatiron() {

    }

    @Override
    public void setMode() {

    }
}
