package com.ccc.parse;

import com.ccc.dto.Order;
import com.ccc.factory.BeverageFactory;
import com.ccc.model.beverage.Beverage;
import com.ccc.model.beverage.Juice;
import com.ccc.model.beverage.OrangeJuice;
import com.ccc.model.snack.BaconRoll;
import com.ccc.model.snack.Snack;
import com.ccc.validation.OrderValidations;
import java.util.Arrays;
import java.util.List;

/**
 * A parser to parse the user input order string into the {@code Order} DTO
 */
public class OrderParser {

    private OrderParser() {
    }

    /**
     * Parses the user input order string into the {@code Order} DTO
     * @param customerOrder
     * @return Order - a DTO with all the order details
     */
    public static Order parseCustomerOrder(String customerOrder) {
        Order order = new Order();
        String[] orderTokens = Arrays.stream(customerOrder.split("[,\\r?\\n]"))
                .map(String::trim).toArray(String[]::new);
        List.of(orderTokens).forEach(s -> {
            if (s.matches("(?).*coffee.*")) {
                parseCoffeeOrder(order, s);
            } else if (s.matches("(?).*bacon roll.*")) {
                parseSnackOrder(order);
            } else if (s.matches("(?).*orange juice.*")) {
                parseJuiceOrder(order);
            }
        });
        OrderValidations.validateOrder(order);
        return order;
    }

    private static void parseCoffeeOrder(Order order, String coffeeOrderStr) {
        String[] coffeeOrder = coffeeOrderStr.split(" ");
        String sizeStr = coffeeOrder[0];
        Beverage coffee = BeverageFactory.getCoffee(coffeeOrderStr, sizeStr);
        order.getBeverages().add(coffee);
        order.getExtras().addAll(coffee.getExtras());
    }

    private static void parseSnackOrder(Order order) {
        Snack snack = new BaconRoll();
        order.getSnacks().add(snack);
    }

    private static void parseJuiceOrder(Order order) {
        Juice juice = new OrangeJuice();
        order.getBeverages().add(juice);
    }
}
