package parte1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Factura {

    private Cliente cliente;

    private List<Item> listaItem;

    private double total;

    public Factura(Cliente cliente, List<Item> listaItem) {
        this.cliente = cliente;
        this.listaItem = listaItem;
    }

    public Factura() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItem() {
        return listaItem;
    }

    public void setListaItem(ArrayList<Item> listaItem) {
        this.listaItem = listaItem;
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
                ", listaItem=" + listaItem +
                ", total=" + total +
                '}';
    }

    public double calcularTotal(){
        double cantidades;
        cantidades = listaItem.stream().mapToDouble(Item::getCantidadComprada).sum();
        this.total = (listaItem.stream().mapToDouble(Item::getCosto).sum())*cantidades;
        return total;
    }
}
