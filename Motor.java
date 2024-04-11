package com.ynov.tp3;

public class Motor {

    private MotorType type;
    private int power;

    public Motor(final MotorType type, final int power) {
        this.type = type;
        this.power = power;
    }

    public enum MotorType {
        DIESEL, ESSENCE, ELECTRIC
    }

    public String toString() {
        return this.type + " | power is " + power + "ch.";
    }
}
