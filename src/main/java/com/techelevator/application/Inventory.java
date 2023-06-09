package com.techelevator.application;

import com.techelevator.models.Item;
import com.techelevator.ui.UserOutput;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Item> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    public void stockItem(Item Item) {
        inventory.add(Item);
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void display() {
        UserOutput.displayMessage("Vending Machine Stock:");
        for (Item eachItem : inventory) {
            if (eachItem.getQuantity() == 0) {
                System.out.println(eachItem.getSlotIdentifier() + " | " + eachItem.getName() + " | $" + eachItem.getPrice() + " | " + "Not Available");
            } else {
                System.out.println(eachItem.getSlotIdentifier() + " | " + eachItem.getName() + " | $" + eachItem.getPrice() + " | " + eachItem.getQuantity());
            }
        }
    }

    public boolean hasItemID(String slotId) {
        for (Item eachItem : inventory) {
            if (slotId.equals(eachItem.getSlotIdentifier())) {
                return true;
            }
        }
        return false;
    }

    public Item getItemById(String slotId) {
        Item selectedItem = null;

        for (Item eachItem : inventory) {
            if (slotId.equals(eachItem.getSlotIdentifier())) {
                selectedItem = eachItem;
            }
        }

        return selectedItem;
    }

}




