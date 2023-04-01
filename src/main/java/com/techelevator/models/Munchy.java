package com.techelevator.models;

import java.math.BigDecimal;

public class Munchy extends Item {
    public Munchy(String slotIdentifier, String name, BigDecimal price, String type) {
        super(slotIdentifier, name, price, type);
    }

    @Override
    public String toString() {
        return "Munchy, Munchy, so Good!";
    }
}
