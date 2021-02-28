package module012;

import java.util.Comparator;

public class ElectricalDevice  {

    public ElectricalDevice() {

    }

    static class Sortbypower implements Comparator<ElectricalDevice> {

        public int compare(ElectricalDevice a, ElectricalDevice b) {
            return a.power - b.power;
        }
    }

    private String model;
    private String color;
    private int power;
    public boolean inserted;

    public ElectricalDevice(String model, String color, int power) {
        this.model = model;
        this.color = color;
        this.power = power;
    }

    public ElectricalDevice(String model, int power) {
        this.model = model;
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
