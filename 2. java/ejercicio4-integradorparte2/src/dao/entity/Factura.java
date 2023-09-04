package dao.entity;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int id;
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.items = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal() {
        for (Item item: items) {
            this.total += item.getSubTotal();
        }
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
