package com.ccc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoffeeCornerApplicationTest {

    @Test
    @DisplayName("Test: Valid Customer Order")
    void testValidCustomerOrderProcessing() {
        String order = "large coffee with extra milk, small coffee with special roast, " +
                "small coffee with foamed milk, bacon roll, orange juice";
        Assertions.assertDoesNotThrow(() -> CoffeeCornerApplication.processCustomerOrder(order, 0));
    }

    @Test
    @DisplayName("Test: Apply Bonus Program For Beverage Type Coffee Free")
    void testApplyBonusProgramForBeverageTypeCoffeeFree() {
        String order = "large coffee with extra milk, small coffee with special roast, bacon roll, orange juice";
        Assertions.assertDoesNotThrow(() -> CoffeeCornerApplication.processCustomerOrder(order, 4));
    }

    @Test
    @DisplayName("Test: Apply Bonus Program For Beverage Type Juice Free")
    void testApplyBonusProgramForBeverageTypeJuiceFree() {
        String order = "orange juice";
        Assertions.assertDoesNotThrow(() -> CoffeeCornerApplication.processCustomerOrder(order, 4));
    }
}