package com.ynov.tp3;

public class Factory {

    public static void main(final String[] args) {
        final Motor diesel = new Motor(Motor.MotorType.DIESEL, 100);
        final Brand peugeot = new Brand("Peugeot", Brand.Country.FRANCE);
        final Car car1 = new Car("Peugeot 207", peugeot, 5, 60);
        System.out.println(car1);
        car1.drive(50); // Try to drive without motor and year of construction

        // Add motor, doors, and year of construction
        car1.setMotor(diesel, 5.5);
        car1.setYearOfConstruction(2023);
        car1.addDoors(5);
        System.out.println(car1);

        // Add fuel and drive
        car1.addFuel(800);
        car1.drive(200);
        System.out.println(car1);
    }
}
