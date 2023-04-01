package com.techelevator.ui;

/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * <p>
 * Dependencies: None
 */
public class UserOutput {

    public static void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayPurchaseMenu() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                 Purchase Menu");
        System.out.println("***************************************************");
        System.out.println();
    }
}
