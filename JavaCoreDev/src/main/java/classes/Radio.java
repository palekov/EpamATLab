package main.java.classes;

import com.fasterxml.jackson.annotation.JsonTypeName;
import main.java.interfaces.Tuneable;

@JsonTypeName("radio")

public class Radio extends ElectricalDevice implements Tuneable {

        private int volume = 5;
        private float channel = 92.8f;

        public Radio(String model, String color, int power, int vol, float channel) {
                super(model, color, power);
                this.volume = vol;
                this.channel = channel;
        }

        public Radio(String model, String color, int power) {
                super(model, color, power);
        }

        @Override
        public int getVolume() {
                return this.volume;
        }

        @Override
        public float getChannel() {
                return this.channel;
        }

        @Override
        public void setVolume(int volume) {
                this.volume = volume;
        }

        @Override
        public void setChannel(float channel) {
                this.channel = channel;
        }

        @Override
        public String toString() {
                return this.getClass().getSimpleName() +" { " +
                        "model = '" + this.getModel() + '\'' +
                        ", color = '" + this.getColor() + '\'' +
                        ", power = " + this.getPower() +
                        ", volume = " + this.volume +
                        ", channel = " + this.channel +
                        " }";
        }
}
