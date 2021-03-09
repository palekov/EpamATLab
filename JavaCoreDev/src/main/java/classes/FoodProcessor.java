package main.java.classes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import main.java.ElectricalDevice;
import main.java.interfaces.Adjustable;

@JsonTypeName("foodproc")

public class FoodProcessor extends ElectricalDevice implements Adjustable {

        private String program = "easy";
        private int time = 10;

        public FoodProcessor(String model, String color, int power) {
            super(model, color, power);
        }

        @Override
        public void setProgram(String program) {
                this.program = program;
        }

        @Override
        public void setTime(int time) {
                this.time = time;
        }
    }
