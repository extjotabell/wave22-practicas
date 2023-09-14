package org.example;

import java.util.List;

public class Factura {
    private int id;
    private Cliente cliente;
    private List<Item> items;
    private double totalCompra;

    public Factura(int id, Cliente cliente, List<Item> items, double totalCompra) {
        this.id = id;
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = totalCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", items=" + items +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
