package main.java;

import java.io.Serializable;
import java.util.Comparator;

public abstract class ElectricalDevice implements Serializable {

    private static final long serialVersionUID = 100L;
    private String model;
    private String color;
    private int power;
    public boolean inserted;

    public ElectricalDevice() {
    }

    public ElectricalDevice(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public ElectricalDevice(String model, String color, int power) {
        this.model = model;
        this.color = color;
        this.power = power;
    }

    public static class SortByPower implements Comparator<ElectricalDevice> {

        public int compare(ElectricalDevice a, ElectricalDevice b) {
            return a.power - b.power;
        }
    }

    public void setModel (String model) {
        this.model = model;
    }

    public void setColor (String color) {
        this.color = color;
    }

    public void setPower (int power) {
        this.power = power;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getPower() {
        return power;
    }

    public int getMode() {
        return 0;
    }

    public String getProgram() {
        return null;
    }

    public int getTime() {
        return 0;
    }

    public int getVolume() {
        return 0;
    }

    public float getChannel() {
        return 0;
    }

    public boolean isInserted() {
        return inserted;
    }

    public void setInserted() {
        inserted = true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +" { " +
                "model = '" + model + '\'' +
                ", color = '" + color + '\'' +
                ", power = " + power +
                " }";
    }
}
