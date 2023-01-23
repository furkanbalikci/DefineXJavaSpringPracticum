package org.example;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final String sector;
    private final LocalDate registrationDate;
    private final List<Invoice> invoices = new ArrayList<>();

    public Customer(String name, String sector, LocalDate registrationDate) {
        this.name = name;
        this.sector = sector;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public String getSector() {
        return sector;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }

}

