package org.example;

import java.util.List;

public class Purchase {

    private long number;

    private Client client;

    private List<Product> products;

    private double total;

    public Purchase(long number, Client client, List<Product> products) {
        this.number = number;
        this.client = client;
        this.products = products;
        this.total = calculateTotal();
    }

    public long getNumber() {
        return number;
    }

    public Client getClient() {
        return client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        return total;
    }

    private double calculateTotal(){
        return products.stream().mapToDouble(p -> p.getUnitCost() * p.getQuantity()).sum();
    }
}
