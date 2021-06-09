package com.ccc;

import com.ccc.dto.Order;
import com.ccc.parse.OrderParser;
import com.ccc.service.BonusProgramService;
import com.ccc.service.ReceiptService;
import com.ccc.util.PrintUtil;
import java.util.Scanner;

public class CoffeeCornerApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintUtil.printf("%n%n%s", "***** Welcome to Charlene's Coffee Corner *****");
        while (true) {
            String input = "";
            int stampCount = 0;

            PrintUtil.printf("%n%n%s", "Enter your order (',' delimited items). Otherwise 'Q' or 'q' to exit: ");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("Q")) {
                break;
            }
            PrintUtil.printf("%n%s", "Do you have customer stamp card? Type 'Y' or 'y' for yes and 'N' or 'n' for No: ");
            String stampCard = sc.nextLine();
            boolean hasStampCard = "Y".equalsIgnoreCase(stampCard);
            if (hasStampCard) {
                boolean isValidNumber = false;
                while(!isValidNumber) {
                    PrintUtil.printf("%n%s", "How many stamps(0 to 4) do you have on the card? ");
                    try {
                        stampCount = Integer.parseInt(sc.nextLine());
                        isValidNumber = true;
                    } catch (NumberFormatException ex) {
                        PrintUtil.printf("%n%s", "Ohh! That's an invalid number. Try again.");
                    }
                }
            }
            processCustomerOrder(input, stampCount);
        }
    }

    public static void processCustomerOrder(String customerOrder, int stampCount) {
        try {
            Order order = OrderParser.parseCustomerOrder(customerOrder);
            BonusProgramService.apply(order, stampCount);
            ReceiptService.printReceipt(order);
        } catch (Exception ex) {
            PrintUtil.printf(ex.getMessage());
        }
    }
}
