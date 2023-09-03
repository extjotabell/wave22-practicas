package org.salvonicolas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Supermarket {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        addCustomer(customers, new Customer("42958432", "Aquiles", "Bailoyo"));
        addCustomer(customers, new Customer("96234567", "Cosme", "Fulanito"));
        addCustomer(customers, new Customer("25768239", "Esteban", "Quito"));

        System.out.println("Consultando clientes...");
        printCustomers(customers);

        System.out.println("--------------");

        System.out.println("Quitando un cliente...");
        customers.remove(0);
        System.out.println("Consultando clientes...");
        printCustomers(customers);


        System.out.println("--------------");

        System.out.println("Buscando cliente...");
        searchCustomer(customers, "96234567");
        System.out.println("Buscando cliente...");
        searchCustomer(customers, "Inexistente 🥹");

        System.out.println("--------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite el DNI del cliente a buscar:");
        String dni = scanner.nextLine().trim().replaceAll("[.,\\-_]", "");
        searchCustomer(customers, dni);
    }

    private static Customer findCustomerByDni(List<Customer> customers, String dni) {
        return customers.stream().filter(customer -> customer.getDni().equals(dni)).findFirst().orElse(null);
    }

    private static void searchCustomer(List<Customer> customers, String dni) {
        Customer customerByDni = findCustomerByDni(customers, dni);
        if (customerByDni != null) {
            System.out.println(customerByDni);
        } else {
            System.out.println("No se encontró el usuario con el DNI Nº" + dni);
        }
    }

    private static void printCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private static void addCustomer(List<Customer> customers, Customer customer) {
        customers.add(customer);
    }
}
