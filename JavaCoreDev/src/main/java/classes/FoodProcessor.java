package main.java.classes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import main.java.ElectricalDevice;
import main.java.interfaces.Adjustable;

@JsonTypeName("foodproc")

public class FoodProcessor extends ElectricalDevice implements Adjustable {

        private String program = "easy";
        private int time = 10;

        public FoodProcessor(String model, String color, int power, String program, int time) {
               super(model, color, power);
               this.program = program;
               this.time = time;
        }

        public FoodProcessor(String model, String color, int power) {
            super(model, color, power);
        }

        @Override
        public String getProgram() {
                return this.program;
        }

        @Override
        public int getTime() {
                return this.time;
        }

        @Override
        public void setProgram(String program) {
                this.program = program;
        }

        @Override
        public void setTime(int time) {
                this.time = time;
        }

        @Override
        public String toString() {
                return this.getClass().getSimpleName() +" { " +
                        "model = '" + this.getModel() + '\'' +
                        ", color = '" + this.getColor() + '\'' +
                        ", power = " + this.getPower() +
                        ", program = '" + this.program + '\'' +
                        ", channel = " + this.time +
                        " }";
        }
    }
