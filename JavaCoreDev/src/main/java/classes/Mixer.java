package main.java.classes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import main.java.ElectricalDevice;
import main.java.interfaces.Switchable;
import main.java.exceptions.NonCorrectModeException;

@JsonTypeName("mixer")

public class Mixer extends ElectricalDevice implements Switchable {

        private byte speedMode = 1;

        public Mixer(String model, String color, int power) {
            super(model, color, power);
        }

        public Mixer(String model, int power) {
            super(model, power);
        }

        public Mixer() {
        }

        @Override
        public void setMode(byte mode) throws NonCorrectModeException {
            if (mode <=0 || mode > 3) throw new NonCorrectModeException();
            this.speedMode = mode;
        }
    }
