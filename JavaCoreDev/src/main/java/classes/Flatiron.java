package main.java.classes;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import main.java.ElectricalDevice;
import main.java.interfaces.Switchable;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value= Flatiron.class, name="flatiron"),
        @JsonSubTypes.Type(value= FoodProcessor.class, name="foodproc"),
        @JsonSubTypes.Type(value= Microwave.class, name="microwave"),
        @JsonSubTypes.Type(value= Mixer.class, name="mixer"),
        @JsonSubTypes.Type(value= Radio.class, name="radio"),
        @JsonSubTypes.Type(value= Television.class, name="television"),
        @JsonSubTypes.Type(value= Torchere.class, name="torchere")
})
public
class Flatiron extends ElectricalDevice implements Switchable {

        Flatiron(String model, String color, int power) {
            super(model, color, power);
        }

        Flatiron(String model, int power) {
            super(model, power);
        }

        Flatiron() { }

        @Override
        public void setMode() {

        }
    }
