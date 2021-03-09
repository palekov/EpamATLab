package main.java.classes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import main.java.ElectricalDevice;

@JsonTypeName("torchere")

public class Torchere extends ElectricalDevice {

        public Torchere(String model, String color, int power) {
            super(model, color, power);
        }

        public Torchere() {

        }
    }