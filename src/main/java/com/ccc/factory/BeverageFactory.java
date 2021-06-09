package com.ccc.factory;

import com.ccc.model.beverage.Beverage;
import com.ccc.model.beverage.Coffee;
import com.ccc.model.beverage.CoffeeSize;
import com.ccc.model.extra.Extra;
import com.ccc.model.extra.ExtraMilk;
import com.ccc.model.extra.FoamedMilk;
import com.ccc.model.extra.SpecialRoast;
import com.ccc.util.BeverageUtil;

/**
 * A class with a factory like method to contain the beverage creation responsibility
 */
public class BeverageFactory {

    private BeverageFactory() {
    }

    public static Beverage getCoffee(String coffeeOrderStr, String sizeStr) {
        CoffeeSize coffeeSize = BeverageUtil.getCoffeeSize(sizeStr);
        Beverage coffee = new Coffee(coffeeSize);
        Extra extra;
        if (coffeeOrderStr.matches("(?).*extra milk.*")) {
            extra = new ExtraMilk();
            coffee.getExtras().add(extra);
        }
        if (coffeeOrderStr.matches("(?).*foamed milk.*")) {
            extra = new FoamedMilk();
            coffee.getExtras().add(extra);
        }
        if (coffeeOrderStr.matches("(?).*special roast.*")) {
            extra = new SpecialRoast();
            coffee.getExtras().add(extra);
        }
        return coffee;
    }
}
