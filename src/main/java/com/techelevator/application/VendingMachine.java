package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

public class VendingMachine {

    private Inventory vendingInventory = new Inventory();
    private InventoryLoader inventoryLoader = new InventoryLoader(vendingInventory);

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
                UserInput.getPurchaseScreenOption();
            } else if (choice.equals("exit")) {
                // goodbye
                break;
            }
        }
    }
}
