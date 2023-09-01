package org.example;

import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> items;
    private double costoTotal;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
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

    public double getCostoTotal() {

        double total = getItems().stream().map(item -> item.getCostoUnitario() + item.getCantidadComprada()).count();
        return total;
    }
}
