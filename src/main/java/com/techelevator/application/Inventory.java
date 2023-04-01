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
            System.out.println(eachItem.getSlotIdentifier() + " | " + eachItem.getName() + " | $" + eachItem.getPrice() + " | " + eachItem.getQuantity());
        }
    }

    public boolean findItemID(String slotID) {
        for (Item eachItem : inventory) {
            if (slotID.equals(eachItem.getSlotIdentifier())) {
                return true;
            }
        }
        return false;
    }

}




