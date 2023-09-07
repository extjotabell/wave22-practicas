package model;

import java.util.ArrayList;
import java.util.List;

public class Factura{

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Cliente cliente;
    private List<Item> items = new ArrayList<>();
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

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }


    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", totalCompra=" + totalCompra +
                '}';
    }

    public Factura(int id, Cliente cliente, List<Item> items) {
        this.id = id;
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = getTotal();
    }

    private double getTotal(){
        return items.stream().mapToDouble(item -> item.getCostoUnitario() * item.getCantidadComprada()).sum();
    }

}
