package com.ccc.model.extra;

public class ExtraMilk extends Extra {

    public ExtraMilk() {
        this.description = "Extra Milk";
    }

    @Override
    public double cost() {
        return 0.30;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
