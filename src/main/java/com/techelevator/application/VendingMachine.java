package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

public class VendingMachine 
{
    private InventoryLoader loader = new InventoryLoader();
    private Inventory vendingInventory = loader.getInventory();



    public void run()
    { //restock method will possibly go here

        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                loader.loadInventory();
                System.out.println("");
                vendingInventory.display(); // display the vending machine slots

            }
            else if(choice.equals("purchase"))
            {
                // make a purchase
            }
            else if(choice.equals("exit"))
            {
                // goodbye
                break;
            }
        }
    }
}
