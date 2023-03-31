package com.techelevator.application;

import com.techelevator.models.Customer;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;

public class VendingMachine {

    private Inventory vendingInventory = new Inventory();
    private InventoryLoader inventoryLoader = new InventoryLoader(vendingInventory);
    private static BigDecimal machineBalance = BigDecimal.ZERO;
    private Customer customer = new Customer(new BigDecimal("20"));

    public static void addToMachineBalance(BigDecimal money) {
        machineBalance = machineBalance.add(money);
    }

    public static BigDecimal getMachineBalance() {
        return machineBalance;
    }

    public void run() {
        inventoryLoader.loadInventory();

        while (true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if (choice.equals("display")) {

                vendingInventory.display();

            } else if (choice.equals("purchase")) {
                // make a purchase
                UserOutput.displayPurchaseMenu();
                String purchaseOptionChoice = UserInput.getPurchaseScreenOption();
                System.out.println(getMachineBalance());

                if (purchaseOptionChoice.equals("feed")) {
                    BigDecimal amount = UserInput.getFeedMoneyAmount();
                    customer.feedMoney(amount);
                }



            } else if (choice.equals("exit")) {
                // goodbye
                break;
            }
        }
    }
}
