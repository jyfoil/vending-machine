package com.techelevator.ui;

import com.techelevator.models.Money;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * <p>
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine(); // ----D---
        String option = selectedOption.trim().toLowerCase(); // D -> d

        if (option.equals("d")) {
            return "display";
        } else if (option.equals("p")) {
            return "purchase";
        } else if (option.equals("e")) {
            return "exit";
        }

        return "";
    }

    public static String getPurchaseScreenOption(Money money) {
        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");

        System.out.println();
        System.out.println("Current Money Provided: $" + money.getMoney());

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equals("m")) {
            return "feed";
        } else if (option.equals("s")) {
            return "select";
        } else if (option.equals("f")) {
            return "finish";
        }

        return "";
    }

    public static BigDecimal getFeedMoneyAmount() {
        System.out.println();
        System.out.print("How much money would you like to feed in to the vending machine: ");

        String selectedOption = scanner.nextLine();
        BigDecimal option = new BigDecimal(selectedOption);
        return option;
    }

    public static String getSlotID() {
        System.out.println();
        System.out.print("Choose an item ID: ");
        String slotID = scanner.nextLine().toUpperCase();
        return slotID;
    }

    public static void pause() {
        System.out.println();
        System.out.println("Press enter to continue...");
        scanner.nextLine();
    }
}
