package com.techelevator.application;

import com.techelevator.models.Item;
import com.techelevator.models.Money;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Audit {

    private static Scanner scanner = new Scanner(System.in);
    private LocalDateTime date = LocalDateTime.now();

    public void writeAudit(Item item, Money money, int numOfItems) {
        String auditFileName = "Audit.txt";
        String output = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy  h:mm:ss a"));
        try (PrintWriter dataOutput = new PrintWriter(new FileOutputStream(auditFileName, true))) {
            if (item != null && numOfItems != 0 && numOfItems % 2 == 0) {
                dataOutput.write(output + " " + item.getName() + " " + item.getSlotIdentifier() + " $" + money.getMoney() + " " + (money.getMoney().subtract(item.getPrice().subtract(BigDecimal.ONE))) +"\n");
                dataOutput.flush();
            } else if (item != null) {
                dataOutput.write(output + " " + item.getName() + " " + item.getSlotIdentifier() + " $" + money.getMoney() + " " + (money.getMoney().subtract(item.getPrice())) +"\n");
                dataOutput.flush();
            } else {
                dataOutput.write(output + " " + "MONEY FED: $" + money.getMoney() + "\n");
                dataOutput.flush();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }
}
