package com.ccc.service;

import com.ccc.dto.Order;
import com.ccc.model.extra.Extra;
import java.util.List;

/**
 * A service class with the responsibility of applying the bonus program on the customer order
 */
public class BonusProgramService {

    private BonusProgramService() {}

    public static void apply(Order order, int stampCount) {
        applyFreeBeverageBonus(order, stampCount);
        applyFreeExtraBonus(order);
    }

    private static void applyFreeBeverageBonus(Order order, int stampCount) {
        var ref = new Object() {
            int count = stampCount;
        };

        order.getBeverages().forEach(beverage -> {
            ref.count++;
            if (ref.count % 5 == 0) {
                order.getDiscountedBeverages().add(beverage);
                List<Extra> extras = beverage.getExtras();
                if (extras != null) {
                    order.getDiscountedExtras().addAll(extras);
                }
            }
        });
    }

    private static void applyFreeExtraBonus(Order order) {
        if (!order.getBeverages().isEmpty() && !order.getSnacks().isEmpty()) {
            order.getExtras().stream().findFirst().ifPresent(extra -> order.getDiscountedExtras().add(extra));
        }
    }
}
