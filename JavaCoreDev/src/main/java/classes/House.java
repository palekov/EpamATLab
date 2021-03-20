package main.java.classes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;

@JsonAutoDetect

public class House {
    public ArrayList devices = new ArrayList<ElectricalDevice>();
}

