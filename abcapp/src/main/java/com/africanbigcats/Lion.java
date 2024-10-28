package com.africanbigcats;

public class Lion extends Panthera {
    public Lion(String name) {
        super(name);
        this.setSpecies("lion");
    }

    @Override
    public String toString() {
        return "{ name: " + name() + ", species: " + species() + ", longitude: " + longitude() + ", latitude: "
                + latitude() + ", fur: " + fur() + " }";
    }

    public String fur() {
        return "mane";
    }
}
