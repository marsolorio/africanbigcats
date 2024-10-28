package com.africanbigcats;

public class Tiger extends Panthera {
    public Tiger(String name) {
        super(name);
        this.setSpecies("tiger");
    }

    @Override
    public String toString() {
        return "{ name: " + name() + ", species: " + species() + ", longitude: " + longitude() + ", latitude: "
                + latitude() + ", fur: " + fur() + " }";
    }

    public String fur() {
        return "stripes";
    }
}
