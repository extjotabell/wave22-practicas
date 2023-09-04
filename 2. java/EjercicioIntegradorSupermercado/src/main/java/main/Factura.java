package main;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> items;
    private double costoTotal;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
    }

    public void agregarItem(Item i) {
        this.items.add(i);
    }

    public void calcularCostoTotal() {
        this.costoTotal = items.stream().mapToDouble(Item::getCostoUnitario).sum();
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
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
}
