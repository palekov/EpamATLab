package main.java.classes;

import main.java.ElectricalDevice;
import main.java.interfaces.Tuneable;

public class Television extends ElectricalDevice implements Tuneable {

        public Television(String model, String color, int power) {
            super(model, color, power);
        }

        public Television() {

        }

        @Override
        public void setVolume() {

        }

        @Override
        public void setChannel() {

        }
    }
