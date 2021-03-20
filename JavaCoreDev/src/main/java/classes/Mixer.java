package main.java.classes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import main.java.interfaces.Switchable;
import main.java.exceptions.NonCorrectModeException;

@JsonTypeName("mixer")

public class Mixer extends ElectricalDevice implements Switchable {

    private int speedMode = 1;

    public Mixer(String model, String color, int power, int mode) {
        super(model, color, power);
        this.speedMode = mode;
    }

    public Mixer(String model, String color, int power) {
        super(model, color, power);
    }

    public Mixer(String model, int power) {
        super(model, power);
    }

    public Mixer() {
    }

    @Override
    public int getMode() {
        return this.speedMode;
    }

    public void setMode(int mode) throws NonCorrectModeException {
        if (mode <= 0 || mode > 3) throw new NonCorrectModeException();
        this.speedMode = mode;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " { " +
                "model = '" + this.getModel() + '\'' +
                ", color = '" + this.getColor() + '\'' +
                ", power = " + this.getPower() +
                ", speed = " + this.speedMode +
                " }";
    }
}
