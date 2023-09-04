package org.example;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private String fecha;
    private double montoTotal;

    public Factura(Cliente cliente, List<Item> items, String fecha, double montoTotal) {
        chequearCliente(cliente);
        this.cliente = cliente;
        this.items = items;
        this.fecha = fecha;
        this.montoTotal = calcularTotal();
    }

    public double calcularTotal()
    {
        return total = items.stream().mapToDouble(Item::getMonto).sum();
    }

    @Override
    public String toString() {
        return "Factura" +
                "cliente=" + cliente +
                ", items=" + items +
                ", fecha='" + fecha + '\'' +
                ", montoTotal=" + montoTotal;
    }
}
