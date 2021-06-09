package com.ccc.model.beverage;

import com.ccc.model.extra.Extra;
import java.util.List;

public abstract class Beverage {
    String description;
    List<Extra> extras;

    public String getDescription() {
        return this.description;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }

    public abstract double cost();
}
