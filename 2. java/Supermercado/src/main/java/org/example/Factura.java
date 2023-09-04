package org.example;

import java.util.List;

public class Factura {
    private List<Item> items;
    private Double total;
    private Cliente cliente;
    private String codigo;

    public Factura(List<Item> items, Cliente cliente, String codigo) {
        this.items = items;
        this.total = this.calcularTotal();
        this.cliente = cliente;
        this.codigo = codigo;
    }

    private Double calcularTotal() {
        return items.stream().mapToDouble(Item::getPrecioTotal).sum();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "items=" + items +
                ", total=" + total +
                ", cliente=" + cliente +
                '}';
    }
}
