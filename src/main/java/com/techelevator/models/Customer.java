package com.techelevator.models;

import com.techelevator.application.VendingMachine;

import java.math.BigDecimal;

public class Customer {

    private BigDecimal currentMoney;

    public Customer(BigDecimal money) {
        this.currentMoney = money;
    }

    public void feedMoney(BigDecimal money) {
        // 1 % 1 = 0
        // 1.25 % 1 = 0.2
        // 5 % 1 = 0
        // 22.42 % 1 = 0.42

        // if (money % 1 == 0)
        boolean isWholeNumber = money.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0;

        if (isWholeNumber) {
            VendingMachine.addToMachineBalance(money);
        }
    }

    public void selectItem() {

    }
}
