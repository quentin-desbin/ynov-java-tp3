package com.ynov.tp3;

public class Car extends Vehicle {
    private final int maxNbDoors;
    private int nbDoors;

    private final double maxFuel;
    private double currentFuel;
    private Double consumption;

    // A simple car constructor
    public Car(final String name, final Brand brand, final int maxNbDoors, final double maxFuel) {
        super(name, brand);
        this.maxNbDoors = maxNbDoors;
        this.nbDoors = 0;
        this.maxFuel = maxFuel;
        this.currentFuel = 0;
        this.consumption = null;
    }

    public void setMotor(final Motor motor, final double consumption) {
        super.setMotor(motor);
        this.consumption = consumption;
    }

    public void addDoors(final int nbDoorsToAdd) {
        final int newNbDoors = nbDoors + nbDoorsToAdd;
        nbDoors = Math.min(newNbDoors, maxNbDoors);
    }

    @Override
    public void drive(final double nbKilometers) {
        if (isConstruct() && currentFuel > 0) {
            double litersConsumed = (nbKilometers * consumption) / 100;
            double newCurrentFuel = currentFuel - litersConsumed;
            if (newCurrentFuel < 0) newCurrentFuel = 0;
            double delta = currentFuel - newCurrentFuel;
            double realDistance  = (delta * 100) / consumption;

            currentFuel = newCurrentFuel;
            addKilometers(realDistance);
        } else {
            System.out.println("[ERROR] cannot drive because car is not constructed or don't have any fuel");
        }
    }

    @Override
    public boolean isConstruct() {
        return super.isConstruct() && nbDoors == maxNbDoors && consumption != null;
    }

    public void addFuel(double nbFuel) {
        final double newFuel = currentFuel + nbFuel;
        currentFuel = Math.min(newFuel, maxFuel);
    }

    public String toString() {
        return super.toString() + "\n" +
                "Doors = " + nbDoors + "/" + maxNbDoors + "\n" +
                "Fuel = " + currentFuel + "/" + maxFuel + "\n" +
                "Consumption = " + consumption + " l/100km";
    }
}
