package org.example.Models;

import java.util.List;
public class Factura {
    private Long id;
    private Cliente cli;
    private List<Item> items;
    private double total;

    public Factura() {
    }

    public Factura(Long id, Cliente cli, List<Item> items, double total) {
        this.id = id;
        this.cli = cli;
        this.items = items;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
