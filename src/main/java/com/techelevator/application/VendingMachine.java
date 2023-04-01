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

    // Instance to keep track of discount
    private int numOfItemsPurchased = 0;

    private void dispenseItem(Item item) {
        System.out.println("Name: " + item.getName() + " | Price: " + item.getPrice() + " | Money remaining: " + machineMoney.getMoney());
        System.out.println(item);
    }

    public void purchaseItem(String slotID) {

        for (Item eachItem : vendingInventory.getInventory()) {

            int itemQuantity = eachItem.getQuantity();
            String itemSlotID = eachItem.getSlotIdentifier();
            BigDecimal itemPrice = eachItem.getPrice();

            if (itemQuantity > 0 && slotID.equals(itemSlotID) && machineMoney.getMoney().compareTo(itemPrice) >= 0) {
                eachItem.decreaseQuantity();
                machineMoney.decreaseMoney(itemPrice);
                System.out.println();
                dispenseItem(eachItem);
                break;
            }

            if (slotID.equals(itemSlotID) && itemQuantity == 0) {
                System.out.println();
                System.out.println("That item is currently not available.");
                break;
            }

            if (slotID.equals(itemSlotID) && machineMoney.getMoney().compareTo(itemPrice) <= 0) {
                System.out.println();
                System.out.println("You do not have enough money to purchase this item.");
                break;
            }
        }

//      Buy one get second one dollar off
        numOfItemsPurchased++;
        if (numOfItemsPurchased % 2 == 0) {
            machineMoney.decreaseMoney(BigDecimal.ONE);
            System.out.println("You have received a $1.00 discount");
        }

    }

    public void run() {
        inventoryLoader.loadInventory();

        while (true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if (choice.equals("display")) {

                vendingInventory.display();
                UserInput.pause();

            } else if (choice.equals("purchase")) {
                boolean keepSelecting = true;

                while (keepSelecting) {

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
                        } else {
                            System.out.println();
                            System.out.println("That item does not exist.");;
                        }
                    }
                }
            } else if (choice.equals("exit")) {
                break;
            }
        }
    }
}
