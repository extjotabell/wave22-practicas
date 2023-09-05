package model;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    private String codigo;
    private Cliente cliente;
    private List<Producto> productoList;

    private Double totalCompra;

    public Factura() {
    }

    public Factura(String codigo, Cliente cliente, List<Producto> productoList, Double totalCompra) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.productoList = productoList;
        this.totalCompra = totalCompra;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigo=" + codigo +
                ", cliente=" + cliente +
                ", productoList=" + productoList +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
