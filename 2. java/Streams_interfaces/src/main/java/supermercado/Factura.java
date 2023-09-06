package supermercado;

import java.util.List;

public class Factura {
    private Integer id;
    private Cliente cliente;
    private List<Item> listaItems;
    private double total;

    //Solo se inicializa el cliente porque las otras variables se agregan en el main
    public Factura(Cliente cliente) {
        this.cliente = cliente;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
