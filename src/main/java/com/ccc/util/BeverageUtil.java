package com.ccc.util;

import com.ccc.constant.Constants;
import com.ccc.exception.ValidationException;
import com.ccc.model.beverage.CoffeeSize;

public class BeverageUtil {

    private BeverageUtil() {}

    public static CoffeeSize getCoffeeSize(String sizeStr) {
        for (CoffeeSize cs : CoffeeSize.values()) {
            if (cs.getSize().equals(sizeStr))
                return cs;
        }
        throw new ValidationException(Constants.INVALID_COFFEE_SIZE_ERROR_MSG);
    }
}
