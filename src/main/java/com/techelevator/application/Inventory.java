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
//    public void display(Item Item) {
//
//    }
}


