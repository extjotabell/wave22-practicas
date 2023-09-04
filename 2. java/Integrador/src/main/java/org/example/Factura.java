package org.example;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items = new ArrayList<>();
    private Double totalCompra = 0.0;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = calcularTotalCompra();
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

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Double calcularTotalCompra(){
        Double totalAux = 0.0;
        for (Item item : items) {
            totalAux+= (item.getCostoUnitario()* item.getCantidadComprada());
        }
        return totalAux;
    }

    @Override
    public String toString() {
        return "Factura: \n" +
                "cliente: " + cliente +
                "\n, items: " + items +
                "\n, totalCompra: " + totalCompra;
    }
}
