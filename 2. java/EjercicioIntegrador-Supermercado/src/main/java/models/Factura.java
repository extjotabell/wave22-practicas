package models;

import Repositories.FacturaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class Factura {
    private Cliente cliente;
    public List<Producto> producto;
    public double totalCompra;

    public Factura(Cliente cliente, List<Producto> producto) {
        this.cliente = cliente;
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
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
                ", producto=" + producto.stream().map(Producto::toString).collect(Collectors.toList()) +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
