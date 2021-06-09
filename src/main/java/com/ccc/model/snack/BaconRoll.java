package com.ccc.model.snack;

public class BaconRoll extends Snack {

    public BaconRoll() {
        this.description = "Bacon Roll";
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double cost() {
        return 4.50;
    }
}
