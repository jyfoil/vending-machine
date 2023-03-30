package com.techelevator.application;

import com.techelevator.models.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Item> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    //methods
    //stock - add item
    public void stockItem(Item Item) {
        inventory.add(Item);
    }
    //display method -- not sure if it goes here??
    public void display() {
        for (Item eachItem : inventory) {
            System.out.println(eachItem.getSlotIdentifier() + " " + eachItem.getName() + " " + eachItem.getPrice() + " " + eachItem.getQuantity());
        }
    }

//            list of all items in the machine with its quantity remaining:
//            Each product has a slot identifier and a purchase price.
//            Each slot has enough room for 6 of that product.
//                    Every product is initially stocked to the maximum amount.
//            A product that has run out must indicate that it is NO LONGER AVAILABLE.

    }




