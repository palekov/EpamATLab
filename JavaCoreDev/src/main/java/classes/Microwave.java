package main.java.classes;

import main.java.ElectricalDevice;
import main.java.interfaces.Adjustable;

class Microwave extends ElectricalDevice implements Adjustable {

        Microwave(String model, String color, int power) {
            super(model, color, power);
        }

        Microwave() {

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
