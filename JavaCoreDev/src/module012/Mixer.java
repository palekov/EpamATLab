package module012;

public class Mixer extends ElectricalDevice implements Switchable {

    public Mixer(String model, String color, int power) {
        super(model, color, power);
    }

    public Mixer(String model, int power) {
        super(model, power);
    }

    @Override
    public void setMode() {

    }
}
