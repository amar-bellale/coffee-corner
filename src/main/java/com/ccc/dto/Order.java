package com.ccc.dto;

import com.ccc.model.beverage.Beverage;
import com.ccc.model.extra.Extra;
import com.ccc.model.snack.Snack;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO to store the order details after parsing customer order input
 */
public class Order {
    private final List<Beverage> beverages;
    private final List<Snack> snacks;
    private final List<Extra> extras;

    private final List<Beverage> discountedBeverages;

    private final List<Extra> discountedExtras;

    public Order() {
        this.beverages = new ArrayList<>();
        this.snacks = new ArrayList<>();
        this.extras = new ArrayList<>();
        this.discountedBeverages = new ArrayList<>();
        this.discountedExtras = new ArrayList<>();
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }

    public List<Snack> getSnacks() {
        return snacks;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public List<Beverage> getDiscountedBeverages() {
        return discountedBeverages;
    }

    public List<Extra> getDiscountedExtras() {
        return discountedExtras;
    }
}
