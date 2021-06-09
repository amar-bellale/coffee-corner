package com.ccc.model.extra;

public class FoamedMilk extends Extra {

    public FoamedMilk() {
        this.description = "Foamed Milk";
    }

    @Override
    public double cost() {
        return 0.50;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
