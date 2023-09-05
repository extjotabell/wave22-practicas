package org.example;

import java.util.List;

public class Factura {

    private int id;

    private Cliente cliente;
    private List<Item> items;
    private double costoTotal;

    public Factura(int numero, Cliente cliente, List<Item> items) {
        this.id = numero;
        this.cliente = cliente;
        this.items = items;
        setCostoTotal();
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

    public void setCostoTotal(){
        this.costoTotal = getCostoTotal();
    }

    public double getCostoTotal() {

        double total = getItems().stream().mapToDouble(item -> item.getCostoUnitario() + item.getCantidadComprada()).sum();
        return total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Factura{\n" +
                "cliente=" + cliente +
                ", \nitems=" + items +
                ", \ncostoTotal=" + costoTotal +
                '}';
    }
}
