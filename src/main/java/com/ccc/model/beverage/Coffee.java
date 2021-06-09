package com.ccc.model.beverage;

import java.util.ArrayList;

public class Coffee extends Beverage {
    private CoffeeSize size;

    public Coffee(CoffeeSize size) {
        this.description = "Coffee";
        this.size = size;
        this.extras = new ArrayList<>();
    }

    public CoffeeSize getSize() {
        return size;
    }

    public void setSize(CoffeeSize size) {
        this.size = size;
    }

    @Override
    public String getDescription() {
        return this.description + " (" + size.toString().charAt(0) + ")";
    }

    @Override
    public double cost() {
        switch (size) {
            case SMALL:
                return 2.50;
            case MEDIUM:
                return 3.00;
            case LARGE:
                return 3.50;
            default: return 0.0;
        }
    }
}
