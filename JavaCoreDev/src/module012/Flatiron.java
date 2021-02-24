package module012;

public class Flatiron extends ElectricalDevice implements Switchable {

    public Flatiron(String model, String color, int power) {
        super(model, color, power);
    }

    public Flatiron(String model, int power) {
        super(model, power);
    }

    @Override
    public void setMode() {

    }
}
