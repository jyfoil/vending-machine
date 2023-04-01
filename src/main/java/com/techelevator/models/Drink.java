package com.techelevator.models;

import java.math.BigDecimal;

public class Drink extends Item {
    public Drink(String slotIdentifier, String name, BigDecimal price, String type) {
        super(slotIdentifier, name, price, type);
    }

    @Override
    public String toString() {
        return "Drinky, Drinky, Slurp Slurp!";
    }
}
