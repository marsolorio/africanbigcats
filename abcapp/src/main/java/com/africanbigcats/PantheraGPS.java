package com.africanbigcats;

import java.util.Random;

/*
 * The PantheraGPS class provides GPS tracking information for panthera species.
 * It contains attributes and methods for retrieving the animal's longitude and latitude.
 */
public class PantheraGPS {
    private String name;
    private String species;
    private float longitude;
    private float latitude;
    private Random random;

    // Constructor
    public PantheraGPS(String name) {
        this.name = name;
        this.random = new Random();
        this.longitude = random.nextFloat() * 100;
        this.latitude = random.nextFloat() * 100;
    }

    // Getter for name
    public String name() {
        return name;
    }

    // Getter for species
    public String species() {
        return species;
    }

    // Setter for species
    public void setSpecies(String species) {
        this.species = species;
    }

    // Method to simulate movement
    public void move() {
        longitude += random.nextFloat() - 0.5;
        latitude += random.nextFloat() - 0.5;
    }

    // Get current longitude
    public float longitude() {
        return longitude;
    }

    // Get current latitude
    public float latitude() {
        return latitude;
    }
}
