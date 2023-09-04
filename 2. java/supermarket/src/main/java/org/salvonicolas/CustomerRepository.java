package org.salvonicolas;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements CRUD<Customer>{
    private final List<Customer> customers;

    public CustomerRepository() {
        customers = new ArrayList<>();
    }

    @Override
    public void remove(Customer element) {
        customers.remove(element);
    }

    @Override
    public void add(Customer element) {
        customers.add(element);
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    @Override
    public Customer get(int index) {
        return customers.get(index);
    }

    @Override
    public void print() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private Customer findCustomerByDNI(String dni) {
        return customers.stream().filter(customer -> customer.getDni().equals(dni)).findFirst().orElse(null);
    }

    public void removeByDNI(String dni) {
        Customer customerByDNI = findCustomerByDNI(dni);
        if (customerByDNI != null) {
            customers.remove(customerByDNI);
            System.out.println("Se eliminó el cliente con el DNI Nª" + dni);
        } else {
            System.out.println("No se encontró el cliente con el DNI Nº" + dni);
        }
    }

    public void searchCustomer(String dni) {
        Customer customerByDNI = findCustomerByDNI(dni);
        if (customerByDNI != null) {
            System.out.println(customerByDNI);
        } else {
            System.out.println("No se encontró el cliente con el DNI Nº" + dni);
        }
    }
}
