package com.ccc.model.extra;

public class SpecialRoast extends Extra {

    public SpecialRoast() {
        this.description = "Special Roast";
    }

    @Override
    public double cost() {
        return 0.90;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
