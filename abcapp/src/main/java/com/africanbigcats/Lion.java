package com.africanbigcats;

/*
 * The Lion class represents a specific type of Panthera with a mane.
 */
public class Lion extends Panthera {
    public Lion(String name) {
        super(name, "Lion");
    }

    public String fur() {
        return "mane";
    }

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
