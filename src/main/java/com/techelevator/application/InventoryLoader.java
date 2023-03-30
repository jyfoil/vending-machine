package com.techelevator.application;

import com.techelevator.models.Candy;
import com.techelevator.models.Drink;
import com.techelevator.models.Gum;
import com.techelevator.models.Munchy;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class InventoryLoader {

    //method

    public void loadInventory() { //get ID number, name, price and type item
        // File at root
        File inventoryFile = new File("catering.csv");

        try(Scanner inventoryReader = new Scanner(inventoryFile)) {
            while(inventoryReader.hasNextLine()) {
                String inventoryItem = inventoryReader.nextLine();
                String[] itemInformation = inventoryItem.split(",");
                //  1      2        3      4
                //  A1   U-Chews   1.65    Gum
                String slotIdentifier = itemInformation[0];
                String name = itemInformation[1];
                BigDecimal price = new BigDecimal(itemInformation[2]);
                String type = itemInformation[3];

                if(type.equals("Gum")) {
                    Gum gum = new Gum(slotIdentifier, name, price,  type);
                    //now add gum item to list
                } else if(type.equals("Drink")) {
                    Drink drink = new Drink(slotIdentifier, name, price,  type);
                } else if(type.equals("Candy")) {
                    Candy candy = new Candy(slotIdentifier, name, price,  type);
                } else if(type.equals("Munchy")) {
                    Munchy munchy = new Munchy(slotIdentifier, name, price,  type);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
