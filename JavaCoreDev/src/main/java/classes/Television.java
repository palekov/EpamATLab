package main.java.classes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import main.java.ElectricalDevice;
import main.java.interfaces.Tuneable;

@JsonTypeName("television")

public class Television extends ElectricalDevice implements Tuneable {

        private int volume = 7;
        private float channel = 895.5f;

        public Television(String model, String color, int power) {
                super(model, color, power);
        }

        public Television() {

        }

        @Override
        public void setVolume(int volume) {
                this.volume = volume;
        }

        @Override
        public void setChannel(float channel) {
                this.channel = channel;
        }
}
