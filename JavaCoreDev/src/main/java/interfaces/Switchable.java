package main.java.interfaces;

import main.java.exceptions.NonCorrectModeException;

public interface Switchable {
    void setMode(int mode) throws NonCorrectModeException;
}
