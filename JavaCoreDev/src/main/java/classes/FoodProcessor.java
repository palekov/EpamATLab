package main.java.classes;

import main.java.ElectricalDevice;
import main.java.interfaces.Adjustable;

class FoodProcessor extends ElectricalDevice implements Adjustable {

        FoodProcessor(String model, String color, int power) {
            super(model, color, power);
        }

        FoodProcessor() {

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
