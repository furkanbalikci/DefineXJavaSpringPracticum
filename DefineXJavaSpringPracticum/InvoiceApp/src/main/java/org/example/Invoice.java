package org.example;

import java.time.LocalDate;

public class Invoice {
    private final double amount;
    private final LocalDate date;

    public Invoice(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
