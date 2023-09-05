package org.example;

import java.util.List;

public class Factura {
    private Integer id;
    private Cliente cliente;
    private List<Item> items;
    private Double total;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.total = calcularTotal(items);
    }

    private Double calcularTotal(List<Item> items){
        this.total = items.stream().mapToDouble(Item::getCostoUnitario).sum();
        return total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
