package com.techelevator.models;

import java.math.BigDecimal;

public class Item {

    private String slotIdentifier;
    private String name;
    private BigDecimal price;
    private String type;
    private int quantity;
    private final int MAX_QUANTITY = 6;

    public Item (String slotIdentifier,String name, BigDecimal price,  String type) {
        this.slotIdentifier = slotIdentifier;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = MAX_QUANTITY;
    }

    public String getSlotIdentifier() {
        return slotIdentifier;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decreaseQuantity() {
        this.quantity -= 1;
    }

}
