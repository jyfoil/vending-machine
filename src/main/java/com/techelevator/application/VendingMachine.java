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
    private Audit auditFile = new Audit();
    private int numOfItemsPurchased = 0;

    private void dispenseItem(Item item) {
        System.out.println("Name: " + item.getName() + " | Price: " + item.getPrice() + " | Money remaining: " + machineMoney.getMoney());
        System.out.println(item);
    }

    public void purchaseItem(String slotID) {


        if (vendingInventory.hasItemID(slotID)) {
            Item selectedItem = vendingInventory.getItemById(slotID);
            int itemQuantity = selectedItem.getQuantity();
            BigDecimal itemPrice = selectedItem.getPrice();

            if (itemQuantity == 0) {
                System.out.println();
                System.out.println("That item is currently not available.");
            } else if (machineMoney.getMoney().compareTo(itemPrice) <= 0) {
                System.out.println();
                System.out.println("You do not have enough money to purchase this item.");
            }

            if (itemQuantity > 0 && machineMoney.getMoney().compareTo(itemPrice) >= 0) {
                selectedItem.decreaseQuantity();
                numOfItemsPurchased++;
                if (numOfItemsPurchased != 0 && numOfItemsPurchased % 2 == 0) {
                    BigDecimal subtractedPrice = itemPrice.subtract(BigDecimal.ONE);
                    auditFile.writeAudit(selectedItem, machineMoney, numOfItemsPurchased, BigDecimal.ZERO);
                    machineMoney.decreaseMoney(subtractedPrice);
                    System.out.println("You have received a $1.00 discount.");
                } else {
                    auditFile.writeAudit(selectedItem, machineMoney, numOfItemsPurchased, BigDecimal.ZERO);
                    machineMoney.decreaseMoney(itemPrice);
                }
                System.out.println();
                dispenseItem(selectedItem);
            }

        } else {
            System.out.println();
            System.out.println("That item does not exist.");
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
                        machineMoney.addMoney(amount);
                        auditFile.writeAudit(null, machineMoney, numOfItemsPurchased, amount);

                    } else if (purchaseOptionChoice.equals("select")) {

                        vendingInventory.display();
                        String slotIDChoice = UserInput.getSlotID();
                        purchaseItem(slotIDChoice);

                    } else if (purchaseOptionChoice.equals("finish")) {
                        BigDecimal remainingMoney = machineMoney.getMoney();
                        auditFile.writeAudit(null, machineMoney, numOfItemsPurchased, null);
                        machineMoney.displayChange(remainingMoney);
                        keepSelecting = false;
                    }
                }
            } else if (choice.equals("exit")) {
                break;
            }
        }
    }
}
