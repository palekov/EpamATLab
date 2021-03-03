package main.java.classes;

import main.java.ElectricalDevice;
import main.java.interfaces.Adjustable;

public class FoodProcessor extends ElectricalDevice implements Adjustable {

    public FoodProcessor(String model, String color, int power) {
        super(model, color, power);
    }

    public FoodProcessor() {

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
