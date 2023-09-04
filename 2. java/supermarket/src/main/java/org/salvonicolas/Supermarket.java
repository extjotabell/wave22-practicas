package org.salvonicolas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Supermarket {
    public static void main(String[] args) {
        CustomerRepository customers = new CustomerRepository();

        Customer customer1 = new Customer("42958432", "Aquiles", "Bailoyo");
        Customer customer2 = new Customer("96234567", "Cosme", "Fulanito");
        Customer customer3 = new Customer("25768239", "Esteban", "Quito");

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        System.out.println("Consultando clientes...");
        customers.print();

        System.out.println("--------------");

        System.out.println("Quitando un cliente...");
        customers.removeByDNI("42958432");
        System.out.println("Consultando clientes...");
        customers.print();


        System.out.println("--------------");

        System.out.println("Buscando cliente...");
        customers.searchCustomer("96234567");
        System.out.println("Buscando cliente...");
        customers.searchCustomer("Inexistente 🥹");

        System.out.println("--------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite el DNI del cliente a buscar:");
        String dni = scanner.nextLine().trim().replaceAll("[.,\\-_]", "");
        customers.searchCustomer(dni);

        System.out.println("-------------- Parte II --------------");
        InvoiceRepository invoices = new InvoiceRepository();

        Item bread = new Item(1, "Pan", 100);
        Item butter = new Item(2, "Manteca", 300);
        Item jam = new Item(3, "Mermelada", 200);

        Invoice invoice1 = new Invoice(customers.get(0));
        invoice1.addItem(bread, 5);
        invoice1.addItem(butter, 1);
        invoice1.addItem(jam, 1);

        invoice1.printTotal();

        System.out.println("--------------");

        invoices.add(invoice1);

        invoices.print();

    }
}
