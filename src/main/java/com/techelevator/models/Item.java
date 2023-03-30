package com.techelevator.models;

import java.math.BigDecimal;

public class Item {

    //variables
    private String slotIdentifier;
    private String name;
    private BigDecimal price;
    private String type;
    private int quantity;


    //constructor

    public Item (String slotIdentifier,String name, BigDecimal price,  String type) {
        this.slotIdentifier = slotIdentifier;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = 6;
    }


    //methods

        //print


}
