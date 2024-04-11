package com.ynov.tp3;

public class Car {

    private final String name;
    private final Brand brand;
    private final int maxNbDoors;
    private final double maxFuel;

    private Motor motor;

    private Integer yearOfConstruction;
    private int nbDoors;

    private double nbKilometers;
    private double currentFuel;
    private Double consumption;

    // A simple car constructor
    public Car(final String name, final Brand brand, final int maxNbDoors, final double maxFuel) {
        this.name = name;
        this.brand = brand;
        this.maxNbDoors = maxNbDoors;
        this.maxFuel = maxFuel;
    }

    // A more complete car constructor
    public Car(final String name, final Brand brand, final int maxNbDoors, final double maxFuel, final Motor motor, final double consumption) {
        this(name, brand, maxNbDoors, maxFuel);
        this.motor = motor;
        this.consumption = consumption;
    }

    public void addDoors(final int nbDoorsToAdd) {
        final int newNbDoors = nbDoors + nbDoorsToAdd;
        nbDoors = Math.min(newNbDoors, maxNbDoors);
    }

    public void setMotor(final Motor motor, final double consumption) {
        this.motor = motor;
        this.consumption = consumption;
    }

    public void setYearOfConstruction(final int yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public boolean isConstruct() {
        return yearOfConstruction != null && nbDoors == maxNbDoors && motor != null;
    }

    public void drive(final double nbKilometers) {
        if (isConstruct() && currentFuel > 0) {
            double litersConsumed = (nbKilometers * consumption) / 100;
            double newCurrentFuel = currentFuel - litersConsumed;
            if (newCurrentFuel < 0) newCurrentFuel = 0;
            double delta = currentFuel - newCurrentFuel;
            double realDistance  = (delta * 100) / consumption;

            currentFuel = newCurrentFuel;
            this.nbKilometers += realDistance;
        } else {
            System.out.println("[ERROR] cannot drive because car is not constructed or don't have any fuel");
        }
    }

    public void addFuel(double nbFuel) {
        final double newFuel = currentFuel + nbFuel;
        currentFuel = Math.min(newFuel, maxFuel);
    }

    public String toString() {
        return "--------------------\n" +
                "Car name = " + name + "\n" +
                "Brand = " + brand + "\n" +
                "Motor = " + motor + "\n" +
                "Doors = " + nbDoors + "/" + maxNbDoors + "\n" +
                "Fuel = " + currentFuel + "/" + maxFuel + "\n" +
                "Consumption = " + consumption + " l/100km" + "\n" +
                "Nb kilometers = " + nbKilometers + "\n" +
                (isConstruct() ? "Year of construction = " + yearOfConstruction : "Not yet construct");
    }
}
