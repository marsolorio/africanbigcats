package com.africanbigcats;

/*
 * The Tiger class represents a specific type of Panthera with distinctive fur.
 * It inherits from the Panthera class, adding a unique fur attribute.
 */
public class Tiger extends Panthera {

    /*
     * Constructor for Tiger.
     * Initializes the name attribute and sets the species to "Tiger".
     */
    public Tiger(String name) {
        super(name, "Tiger");
    }

    /*
     * Provides a string representation of the Tiger's fur pattern.
     * Specific to Tiger, it returns "stripes".
     */
    @Override
    public String fur() {
        return "stripes";
    }

    /*
     * Override of the toString method to include fur pattern.
     * Returns a JSON-like string representation of the Tiger's details.
     */
    @Override
    public String toString() {
        return "{ name: " + name() +
                ", species: " + species() +
                ", longitude: " + longitude() +
                ", latitude: " + latitude() +
                ", fur: " + fur() +
                " }";
    }
}
