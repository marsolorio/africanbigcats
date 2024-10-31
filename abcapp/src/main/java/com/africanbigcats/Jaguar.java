package com.africanbigcats;

/*
 * The Jaguar class represents a specific type of Panthera with spots and a sleeping habit.
 */
public class Jaguar extends Panthera {
    private boolean sleepsInTrees = true;

    public Jaguar(String name) {
        super(name, "Jaguar");
    }

    public String fur() {
        return "spots";
    }

    public boolean sleepsInTrees() {
        return sleepsInTrees;
    }

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
