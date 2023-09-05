package org.example.clases;

import java.util.ArrayList;

public class Factura {
    private Cliente cliente;
    private ArrayList<Item> lista;
    private Integer total;

    public Factura(Cliente cliente, ArrayList<Item> lista) {
        this.cliente = cliente;
        this.lista = lista;
        Integer total = 0;
        for (Item item: lista) {
            total+=(item.getCosto()*item.getCantidad());
        }
        this.total = total;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Item> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Item> lista) {
        this.lista = lista;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", total=" + total +
                '}';
    }
}
