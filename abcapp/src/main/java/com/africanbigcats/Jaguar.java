package com.africanbigcats;

public class Jaguar extends Panthera {
    private boolean sleepsInTrees = true;

    public Jaguar(String name) {
        super(name);
        this.setSpecies("jaguar");
    }

    @Override
    public String toString() {
        return "{ name: " + name() + ", species: " + species() + ", longitude: " + longitude() + ", latitude: "
                + latitude() + ", fur: " + fur() + ", sleepsInTrees: " + sleepsInTrees + " }";
    }

    public String fur() {
        return "spots";
    }

    public boolean sleepsInTrees() {
        return sleepsInTrees;
    }
}
