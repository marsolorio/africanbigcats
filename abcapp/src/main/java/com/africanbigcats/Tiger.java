package com.africanbigcats;

/*
 * The Tiger class represents a specific type of Panthera with distinctive fur.
 */
public class Tiger extends Panthera {
    public Tiger(String name) {
        super(name, "Tiger");
    }

    public String fur() {
        return "stripes";
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
