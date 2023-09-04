package model;

import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> items;
    private double totalCompra;

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

    public double calcularTotal(){
        this.totalCompra = items.stream().mapToDouble(item -> item.getPrecio()*item.getCantidadComprada()).sum();
        return this.totalCompra;
    }

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
