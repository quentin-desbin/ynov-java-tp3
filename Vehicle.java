package com.ynov.tp3;

public abstract class Vehicle {

    private final String name;
    private final Brand brand;
    private Motor motor;

    private Integer yearOfConstruction;
    private double nbKilometers;

    public Vehicle(final String name, final Brand brand) {
        this.name = name;
        this.brand = brand;
    }

    public Vehicle(final String name, final Brand brand, final Motor motor) {
        this.name = name;
        this.brand = brand;
        this.motor = motor;
    }

    abstract void drive(double nbKilometers);

    public void setMotor(final Motor motor) {
        this.motor = motor;
    }

    public void setYearOfConstruction(final int yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public boolean isConstruct() {
        return yearOfConstruction != null && motor != null;
    }

    protected void addKilometers(double nbKilometers) {
        this.nbKilometers += nbKilometers;
    }

    public String toString() {
        return "--------------------\n" +
                "Vehicule name = " + name + "\n" +
                "Brand = " + brand + "\n" +
                "Motor = " + motor + "\n" +
                "Nb kilometers = " + nbKilometers + "\n" +
                (isConstruct() ? "Year of construction = " + yearOfConstruction : "Not yet construct");
    }
}
