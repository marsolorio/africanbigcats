package com.africanbigcats;

import java.util.Random;

/*
 * PantheraGPS base class that simulates GPS information.
 */
public class PantheraGPS {

    private final Integer maxLongitude = 1000;
    private final Integer maxLatitude = 1000;
    protected final float minSpeed = 0f;
    protected final float maxSpeed = 50.0f;

    private String name;
    private String species;

    private Float longitude;
    private Float latitude;

    private Random longitudeRandom;
    private Random latitudeRandom;

    public PantheraGPS(String name) {
        this.name = name;
        this.species = "pantheraGPS";

        this.longitudeRandom = new Random();
        this.longitudeRandom.setSeed(this.seed(name + "longitude"));
        this.latitudeRandom = new Random();
        this.latitudeRandom.setSeed(this.seed(name + "latitude"));

        this.longitude = longitudeRandom.nextFloat() * maxLongitude;
        this.latitude = latitudeRandom.nextFloat() * maxLatitude;
    }

    public String toString() {
        return "{ name: " + name + ", species: " + this.species + ", longitude: " + this.longitude + ", latitude: "
                + this.latitude + " }";
    }

    public String name() {
        return this.name;
    }

    public String species() {
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    private Integer seed(String s) {
        Integer seed = 0;
        for (int i = 0; i < s.length(); i++) {
            seed += s.charAt(i);
        }
        return seed;
    }

    public void move() {
        this.longitude += longitudeRandom.nextFloat() * maxSpeed;
        this.latitude += latitudeRandom.nextFloat() * maxSpeed;
    }

    public Float longitude() {
        return longitude;
    }

    public Float latitude() {
        return latitude;
    }
}
