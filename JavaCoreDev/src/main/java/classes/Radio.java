package main.java.classes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import main.java.ElectricalDevice;
import main.java.interfaces.Tuneable;

@JsonTypeName("radio")

public class Radio extends ElectricalDevice implements Tuneable {

        private int volume = 5;
        private float channel = 92.8f;

        public Radio(String model, String color, int power) {
                super(model, color, power);
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
