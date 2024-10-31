package com.africanbigcats;

/*
 * The Jaguar class represents a specific type of Panthera with unique attributes.
 * Jaguars have a distinctive fur pattern (spots) and often sleep in trees.
 */
public class Jaguar extends Panthera {

    // Indicates whether the Jaguar sleeps in trees, specific to this species
    private boolean sleepsInTrees = true;

    /*
     * Constructor for Jaguar.
     * Initializes the name attribute and sets the species to "Jaguar".
     */
    public Jaguar(String name) {
        super(name, "Jaguar");
    }

    /*
     * Provides a string representation of the Jaguar's fur pattern.
     * Specific to Jaguar, it returns "spots".
     */
    @Override
    public String fur() {
        return "spots";
    }

    /*
     * Returns whether the Jaguar sleeps in trees.
     */
    public boolean sleepsInTrees() {
        return sleepsInTrees;
    }

    /*
     * Override of the toString method to include additional attributes like fur
     * pattern
     * and sleepsInTrees.
     * Returns a JSON-like string representation of the Jaguar's details.
     */
    @Override
    public String toString() {
        return "{ name: " + name() +
                ", species: " + species() +
                ", longitude: " + longitude() +
                ", latitude: " + latitude() +
                ", fur: " + fur() +
                ", sleepsInTrees: " + sleepsInTrees +
                " }";
    }
}
