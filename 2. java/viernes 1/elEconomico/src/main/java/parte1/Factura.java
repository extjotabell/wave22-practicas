package parte1;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Factura {

    private Cliente cliente;

    private ArrayList<Item> listaItem;

    private double total;

    public Factura(Cliente cliente, ArrayList<Item> listaItem, double total) {
        this.cliente = cliente;
        this.listaItem = listaItem;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Item> getListaItem() {
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
}
