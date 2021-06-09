package com.ccc.model.beverage;

public enum CoffeeSize {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    private final String size;

    CoffeeSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return this.size;
    }
}
