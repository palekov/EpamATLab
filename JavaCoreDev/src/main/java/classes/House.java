package main.java;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import main.java.classes.*;

import java.util.ArrayList;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value= Flatiron.class, name="flatiron"),
        @JsonSubTypes.Type(value= FoodProcessor.class, name="foodproc"),
        @JsonSubTypes.Type(value= Microwave.class, name="microwave"),
        @JsonSubTypes.Type(value= Mixer.class, name="mixer"),
        @JsonSubTypes.Type(value= Radio.class, name="radio"),
        @JsonSubTypes.Type(value= Television.class, name="television"),
        @JsonSubTypes.Type(value=Torchere.class, name="torchere")
})

public class House {
    public ArrayList devices = new ArrayList<ElectricalDevice>();
}
