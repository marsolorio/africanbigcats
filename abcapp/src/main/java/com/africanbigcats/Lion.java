package com.africanbigcats;

/*
 * The Lion class represents a specific type of Panthera with a distinctive fur pattern.
 * It inherits from the Panthera class, adding a unique fur attribute.
 */
public class Lion extends Panthera {

    /*
     * Constructor for Lion.
     * Initializes the name attribute and sets the species to "Lion".
     */
    public Lion(String name) {
        super(name, "Lion");
    }

    /*
     * Provides a string representation of the Lion's fur pattern.
     * Specific to Lion, it returns "mane".
     */
    @Override
    public String fur() {
        return "mane";
    }

    /*
     * Override of the toString method to include fur pattern.
     * Returns a JSON-like string representation of the Lion's details.
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
