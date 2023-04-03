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

    public void addMoney(BigDecimal amount) throws NumberFormatException {
        money = money.add(amount);
    }

    public BigDecimal getAddAmount(BigDecimal amount) {
        return amount.setScale(2, RoundingMode.HALF_UP);
    }

    public int[] calculateChange(BigDecimal amount) {
        int dollars = amount.intValue();
        BigDecimal remainingCentsBD = amount.subtract(new BigDecimal(dollars)).multiply(new BigDecimal("100"));
        int remainingCents = remainingCentsBD.intValue();

        int quarters = remainingCents / 25;
        remainingCents %= 25;

        int dimes = remainingCents / 10;
        remainingCents %= 10;

        int nickels = remainingCents / 5;
        remainingCents %= 5;

        return new int[]{dollars, quarters, dimes, nickels};
    }

    public void displayChange(BigDecimal amount) {
        int[] coins = calculateChange(amount);
        System.out.println();
        System.out.println("Your change is: ");

        if (coins[0] > 0) {
            System.out.print(coins[0] + " dollar(s) ");
        }
        if (coins[1] > 0) {
            System.out.print(coins[1] + " quarter(s) ");
        }
        if (coins[2] > 0) {
            System.out.print(coins[2] + " dime(s) ");
        }
        if (coins[3] > 0) {
            System.out.print(coins[3] + " nickel(s) ");
        }
        System.out.println();
    }

}



