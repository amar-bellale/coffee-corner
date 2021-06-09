package com.ccc.model.beverage;

public class OrangeJuice extends Juice {

    public OrangeJuice() {
        this.description = "Orange Juice";
    }

    @Override
    public double cost() {
        return 3.95;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
