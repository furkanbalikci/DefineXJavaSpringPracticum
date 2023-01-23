package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvoiceSystem  {
    private final List<Customer> customers = new ArrayList<>();
    public void createCustomer(String name, String sector, LocalDate registrationDate){
        customers.add(new Customer(name,sector,registrationDate));
    }

    public List<Customer> getCustomers() {
        return customers;
    }
    public List<Invoice> getInvoices(){
        List<Invoice> invoices = new ArrayList<>();
        for (Customer customer:customers) {
            invoices.addAll(customer.getInvoices());
        }
        return invoices;
    }
    public void addInvoice(String custorName, double amount, LocalDate date){
        for (Customer customer:customers) {
             if (customer.getName().equals(custorName)){
                 customer.addInvoice(new Invoice(amount,date));
             }
        }
    }
}
