package com.techelevator.application;

import com.techelevator.models.Money;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;

public class VendingMachine {

    private Inventory vendingInventory = new Inventory();
    private InventoryLoader inventoryLoader = new InventoryLoader(vendingInventory);
    private Money machineMoney = new Money(BigDecimal.ZERO);

    public void run() {
        inventoryLoader.loadInventory();

        while (true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if (choice.equals("display")) {

                vendingInventory.display();

            } else if (choice.equals("purchase")) {
                UserOutput.displayPurchaseMenu();
                String purchaseOptionChoice = UserInput.getPurchaseScreenOption(machineMoney);

                if (purchaseOptionChoice.equals("feed")) {
                    BigDecimal amount = UserInput.getFeedMoneyAmount();
                    machineMoney.feedMoney(amount);
                } else if (purchaseOptionChoice.equals("select")) {
                    vendingInventory.display();
                    String slotIDChoice = UserInput.getSlotID();
                    boolean itemPresent = vendingInventory.findItemID(slotIDChoice);

                    if (itemPresent) {

                    } else {
                        UserOutput.displayMessage("That item does not exist.");
                    }
                }


            } else if (choice.equals("exit")) {
                break;
            }
        }
    }
}
