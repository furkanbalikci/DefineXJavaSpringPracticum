package org.example;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        InvoiceSystem invoiceSystem = new InvoiceSystem();

        invoiceSystem.createCustomer("John Smith", "Retail", LocalDate.of(2020, 1, 1));
        invoiceSystem.createCustomer("Jane Doe", "Manufacturing", LocalDate.of(2020, 2, 1));
        invoiceSystem.createCustomer("Bob Johnson", "Services", LocalDate.of(2020, 3, 1));
        invoiceSystem.createCustomer("Carla Williams", "Retail", LocalDate.of(2020, 4, 1));
        invoiceSystem.createCustomer("Chris Brown", "Manufacturing", LocalDate.of(2020, 5, 1));

        // Add invoices
        invoiceSystem.addInvoice("John Smith", 1000.0, LocalDate.of(2020, 6, 1));
        invoiceSystem.addInvoice("Jane Doe", 2000.0, LocalDate.of(2020, 6, 15));
        invoiceSystem.addInvoice("Bob Johnson", 500.0, LocalDate.of(2020, 6, 20));
        invoiceSystem.addInvoice("Carla Williams", 1500.0, LocalDate.of(2020, 6, 25));
        invoiceSystem.addInvoice("Chris Brown", 2500.0, LocalDate.of(2020, 6, 30));

        //List of all customers
        System.out.println("All customers:");
        invoiceSystem.getCustomers().forEach(customer ->
                System.out.println(" - " +  customer.getName() + " in " + customer.getSector() + " sector, registered on " + customer.getRegistrationDate()));

        //List customers with 'C' in name
        System.out.println("Customers with 'C' in name:");
        invoiceSystem.getCustomers().stream().filter(customer -> customer.getName().contains("C")).forEach(customer -> System.out.println(" - " + customer.getName()));




        //List total amount of invoices for customers registered in June problem date tarafında olabilir
        double totalAmount = invoiceSystem.getCustomers().stream()
                .filter(customer -> customer.getInvoices().stream().anyMatch(invoice -> invoice.getDate().getMonth().equals(LocalDate.of(2020, 6, 1).getMonth())))
                .mapToDouble(customer -> customer.getInvoices().stream()
                        .filter(invoice -> invoice.getDate().getMonth().equals(LocalDate.of(2020, 6, 1).getMonth()))
                                .mapToDouble(Invoice::getAmount)
                                        .sum()).sum();

        System.out.println("Total amount of invoices for customers registered in June: " + totalAmount);



        //List ol invoices
        System.out.println("All Invoices:");
        invoiceSystem.getInvoices().forEach(invoice -> System.out.println(" - Amount " + invoice.getAmount() + " Date " + invoice.getDate()));

        // List of invoices with amount over 1500
        System.out.println("Invoices with amount over 1500:");
        invoiceSystem.getInvoices().stream().filter(invoice -> invoice.getAmount() > 1500).forEach(invoice -> System.out.println(" - Amount: " + invoice.getAmount() + " Date" + invoice.getDate()));

        //Calculate average amount of invoices over 1500
        double averageAmount = invoiceSystem.getInvoices().stream().filter(invoice -> invoice.getAmount() > 1500).mapToDouble(Invoice::getAmount).average().orElse(0.0);
        System.out.println("Average amount of invoices over 1500: " + averageAmount);

        //List names of customers with invoices under 500
        System.out.print("Customers with invoices under 500: ");
        Map<String, Double> sectorsWithAvgInvoiceAmount = invoiceSystem.getCustomers().stream()
                .filter(customer -> customer.getInvoices().stream()
                        .anyMatch(invoice -> invoice.getDate().getMonth().equals(LocalDate.of(2020, 6, 1).getMonth())))
                .collect(Collectors.groupingBy(
                        Customer::getSector,
                        Collectors.averagingDouble(customer -> customer.getInvoices().stream()
                                .filter(invoice -> invoice.getDate().getMonth().equals(LocalDate.of(2020, 6, 1).getMonth()))
                                .mapToDouble(Invoice::getAmount)
                                .average()
                                .orElse(0.0)
                        )));

        sectorsWithAvgInvoiceAmount.entrySet()
                .stream()
                .filter(entry -> entry.getValue() < 750)
                .forEach(entry -> System.out.println(entry.getKey()));



    }
}
