package main.java.classes;

import main.java.ElectricalDevice;
import main.java.interfaces.Adjustable;

public class Microwave extends ElectricalDevice implements Adjustable {

    public Microwave(String model, String color, int power) {
        super(model, color, power);
    }

    public Microwave() {

    }

    @Override
    public void setProgram() {

    }

    @Override
    public void setPower() {

    }

    @Override
    public void setTime() {

    }
}
