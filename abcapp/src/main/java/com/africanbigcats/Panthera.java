package com.africanbigcats;

import java.util.Random;

/*
 * Panthera class derived from PantheraGPS.
 * Represents a general category for panthera species.
 */
public class Panthera extends PantheraGPS {
    private String name;
    private String species;
    private int weight;
    private Random speedRandom;

    /*
     * Constructor for Panthera.
     * Initializes the name, species, and assigns a random weight between 10 and 600
     * pounds.
     */
    public Panthera(String name, String species) {
        super(name);
        this.name = name;
        this.species = species;
        this.weight = new Random().nextInt(591) + 10;
        this.speedRandom = new Random();
    }

    /*
     * Simulates the panthera's roar sound.
     */
    public void roar() {
        System.out.println("Rrrrrrrrroooooooaaaaarrrrr!");
    }

    /*
     * Returns the current speed as a random value between 0 and maxSpeed.
     */
    public double speed() {
        return speedRandom.nextFloat() * maxSpeed;
    }

    public String name() {
        return name;
    }

    public String species() {
        return species;
    }

    public int weight() {
        return weight;
    }

    /*
     * Provides a JSON-formatted string representation of the panthera's details.
     */
    @Override
    public String toString() {
        return "{ " +
                "name: " + name +
                ", species: " + species +
                ", longitude: " + longitude() +
                ", latitude: " + latitude() +
                ", weight: " + weight + " lbs" +
                ", speed: " + speed() + " mph" +
                " }";
    }
}
