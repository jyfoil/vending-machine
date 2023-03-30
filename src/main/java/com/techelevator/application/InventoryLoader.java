package com.techelevator.application;

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
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
