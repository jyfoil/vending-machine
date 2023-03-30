package com.techelevator.models;

import java.math.BigDecimal;

public class Drinks extends Item {
    public Drinks(String slotIdentifier,String name, BigDecimal price,  String type) {
        super(slotIdentifier, name, price, type);
    }
}
