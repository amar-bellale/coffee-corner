package com.ccc.service;

import com.ccc.dto.Order;
import com.ccc.util.PrintUtil;

/**
 * A service class with the receipt printing responsibility
 */
public class ReceiptService {

    private static final String PAID_ITEM_FORMATTER = "%n%-40s %4.2f";
    private static final String DISCOUNTED_ITEM_FORMATTER = "%n%-39s %4.2f";
    private ReceiptService() {
    }

    /**
     * Prints the formatted receipt for the {@code Order}
     * @param order
     */
    public static void printReceipt(Order order) {
        var ref = new Object() {
            double total;
        };
        appendTitle(centerString(48, "Charlene's Coffee Corner"));
        appendHeaders();

        order.getBeverages().forEach(beverage -> {
            ref.total = ref.total + beverage.cost();
            appendRows(PAID_ITEM_FORMATTER, beverage.getDescription(), beverage.cost());
        });

        order.getSnacks().forEach(snack -> {
            ref.total = ref.total + snack.cost();
            appendRows(PAID_ITEM_FORMATTER, snack.getDescription(), snack.cost());
        });

        order.getExtras().forEach(extra -> {
            ref.total = ref.total + extra.cost();
            appendRows(PAID_ITEM_FORMATTER, extra.getDescription(), extra.cost());
        });

        if (!order.getDiscountedBeverages().isEmpty() ||
                !order.getDiscountedExtras().isEmpty()) {
            appendSeparator();
            appendTitle(centerString(48, "Discounts"));
            order.getDiscountedBeverages().forEach(beverage -> {
                ref.total = ref.total - beverage.cost();
                appendRows(DISCOUNTED_ITEM_FORMATTER, beverage.getDescription(), -beverage.cost());
            });
            order.getDiscountedExtras().forEach(extra -> {
                ref.total = ref.total - extra.cost();
                appendRows(DISCOUNTED_ITEM_FORMATTER, extra.getDescription(), -extra.cost());
            });
        }
        appendFooter(ref.total);
    }

    private static void appendTitle(String title) {
        PrintUtil.printf("%n%s", title);
    }

    private static void appendHeaders() {
        appendSeparator();
        PrintUtil.printf("%n%-40s %6s", "Item Description", "Amount");
        appendSeparator();
    }

    private static void appendRows(String formatter, String desc, double amount) {
        PrintUtil.printf(formatter, desc, amount);
    }

    private static void appendFooter(double total) {
        appendSeparator();
        PrintUtil.printf(PAID_ITEM_FORMATTER, "Total", total);
        appendSeparator();
        PrintUtil.printf("%n%s", centerString(48, "Thank you for your visit!"));
        PrintUtil.printf("%n-----------------------------------------------%n%n");

    }

    private static void appendSeparator() {
        PrintUtil.printf("%n-----------------------------------------------");
    }

    public static String centerString (int width, String s) {
        return width > s.length()
                ? " ".repeat((width - s.length()) / 2) + s + " ".repeat((width - s.length() + 1) / 2)
                : s;
    }
}
