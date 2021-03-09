package main.java.classes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import main.java.ElectricalDevice;
import main.java.interfaces.Adjustable;

@JsonTypeName("microwave")

public class Microwave extends ElectricalDevice implements Adjustable {

        private String program = "heating";
        private int time = 5;

        public Microwave(String model, String color, int power) {
            super(model, color, power);
        }

        @Override
        public void setProgram(String program) {
        }

        @Override
        public void setTime(int time) {
           this.time = time;
        }
    }
