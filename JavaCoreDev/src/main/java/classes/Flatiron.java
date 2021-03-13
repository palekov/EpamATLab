package main.java.classes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import main.java.ElectricalDevice;
import main.java.exceptions.NonCorrectModeException;
import main.java.interfaces.Switchable;

@JsonTypeName("flatiron")

public class Flatiron extends ElectricalDevice implements Switchable {

  private int powerMode = 1;

 public Flatiron(String model, String color, int power, int mode) {
     super(model, color, power);
     this.powerMode = mode;
    }

  public Flatiron(String model, String color, int power) {
            super(model, color, power);
        }

    public void setMode(int mode) throws NonCorrectModeException {
        if (mode <= 0 || mode > 3) throw new NonCorrectModeException();
        this.powerMode = mode;
    }

    @Override
    public int getMode() {
      return this.powerMode;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +" { " +
                "model = '" + this.getModel() + '\'' +
                ", color = '" + this.getColor() + '\'' +
                ", power = " + this.getPower() +
                ", mode = " + this.powerMode +
                " }";
    }
}
