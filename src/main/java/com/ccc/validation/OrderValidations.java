package com.ccc.validation;

import com.ccc.dto.Order;
import com.ccc.constant.Constants;
import com.ccc.exception.ValidationException;

public class OrderValidations {

    private OrderValidations() {}

    public static void validateOrder(Order order) {
        if (order.getBeverages().isEmpty() && order.getSnacks().isEmpty()) {
            throw new ValidationException(Constants.INVALID_ORDER_ERROR_MSG);
        }
    }
}
