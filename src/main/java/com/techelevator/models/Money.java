package com.techelevator.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

    private BigDecimal money;

    public BigDecimal getMoney() {
        return money.setScale(2, RoundingMode.HALF_EVEN);
    }

    public void decreaseMoney(BigDecimal itemPrice) {
        money = money.subtract(itemPrice);
    }

    public Money(BigDecimal amount) {
        money = amount;
    }

    private void addMoney(BigDecimal amount) {
        money = money.add(amount);
    }

    public void feedMoney(BigDecimal amount) {
        boolean isWholeNumber = money.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0;
        if (isWholeNumber) {
            addMoney(amount);
        }
    }
}



