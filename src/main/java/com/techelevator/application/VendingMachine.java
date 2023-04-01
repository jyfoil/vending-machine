package com.techelevator.application;

import com.techelevator.models.Item;
import com.techelevator.models.Money;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;

public class VendingMachine {

    private Inventory vendingInventory = new Inventory();
    private InventoryLoader inventoryLoader = new InventoryLoader(vendingInventory);
    private Money machineMoney = new Money(BigDecimal.ZERO);

    public void dispenseItem(Item item) {
        System.out.println(item);
    }

    public void purchaseItem(String slotID) {
        // Loop through inventory, find the slot ID
        // Decrease item quantity by 1
        // if quantity > 0
        for (Item eachItem : vendingInventory.getInventory()) {

            int itemQuantity = eachItem.getQuantity();
            String itemSlotID = eachItem.getSlotIdentifier();
            BigDecimal itemPrice = eachItem.getPrice();

            if (itemQuantity > 0 && slotID.equals(itemSlotID) && machineMoney.getMoney().compareTo(itemPrice) >= 0) {
                // decrease quantity of item if > 0
                eachItem.decreaseQuantity();
                machineMoney.decreaseMoney(itemPrice);
                dispenseItem(eachItem);
                return;
            }
        }
        UserOutput.displayMessage("You do not have enough money to purchase this item.");
    }

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

                        purchaseItem(slotIDChoice);
                        // dispense(SlotIDChoice)
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
