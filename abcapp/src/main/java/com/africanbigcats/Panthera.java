package com.africanbigcats;

import java.util.Random;

/*
 * Panthera class derived from PantheraGPS.
 * Represents a general category for panthera species.
 */
public class Panthera extends PantheraGPS {

    private int weight;
    private Random speedRandom;

    // Constructor
    public Panthera(String name) {
        super(name);
        this.setSpecies("panthera");

        // Initialize the weight attribute with a random value between 10 and 600 pounds
        this.weight = (int) (Math.random() * 590) + 10;

        // Initialize the Random instance for speed generation
        this.speedRandom = new Random();
    }

    // Method to simulate the panthera's roar
    public void roar() {
        System.out.println("Rrrrrrrrroooooooaaaaarrrrr!");
    }

    // Method to get the current speed, generated as a random value between 0 and
    // maxSpeed
    public double speed() {
        return speedRandom.nextFloat() * maxSpeed; // Random speed from 0 to 50 mph
    }

    // Getter for weight attribute
    public int getWeight() {
        return weight;
    }

    // Override toString method to include additional attributes in JSON format
    @Override
    public String toString() {
        return "{ " +
                "name: " + this.name() +
                ", species: " + this.species() +
                ", longitude: " + this.longitude() +
                ", latitude: " + this.latitude() +
                ", weight: " + this.getWeight() +
                ", speed: " + this.speed() +
                " }";
    }
}
