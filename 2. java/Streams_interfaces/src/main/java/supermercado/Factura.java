package supermercado;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> listaItems;
    private double total;

    public Factura(Cliente cliente, List<Item> listaItems, double total) {
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaItems=" + listaItems +
                ", total=" + total +
                '}';
    }
}
