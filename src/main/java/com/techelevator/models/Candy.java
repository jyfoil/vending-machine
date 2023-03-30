package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends Item {
    public Candy(String slotIdentifier,String name, BigDecimal price,  String type) {
        super(slotIdentifier, name, price, type);
    }
}
