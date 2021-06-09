package com.ccc.parse;

import com.ccc.constant.Constants;
import com.ccc.dto.Order;
import com.ccc.exception.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderParserTest {

    @Test
    @DisplayName("Test: Valid Customer Order Parsing")
    void testValidCustomerOrderParsing() {
        String customerOrder = "large coffee with extra milk, bacon roll, orange juice";
        Order order = OrderParser.parseCustomerOrder(customerOrder);
        Assertions.assertEquals(2, order.getBeverages().size());
        Assertions.assertEquals(1, order.getSnacks().size());
        Assertions.assertEquals(1, order.getExtras().size());
    }

    @Test
    @DisplayName("Test: Invalid Customer Order")
    void testInvalidCustomerOrderProcessing() {
        String customerOrder = "blah blah!";
        Assertions.assertThrows(ValidationException.class,
                () -> OrderParser.parseCustomerOrder(customerOrder),
                Constants.INVALID_ORDER_ERROR_MSG);
    }

    @Test
    @DisplayName("Test: Incorrect Coffee Size")
    void testInValidCoffeeSize() {
        String customerOrder = "xyz coffee";
        Assertions.assertThrows(ValidationException.class,
                () -> OrderParser.parseCustomerOrder(customerOrder),
                Constants.INVALID_COFFEE_SIZE_ERROR_MSG);
    }
}