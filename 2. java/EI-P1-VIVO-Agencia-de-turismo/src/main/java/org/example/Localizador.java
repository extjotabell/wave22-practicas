package org.example;

import org.example.Productos.Producto;

import java.util.List;

public class Localizador {
    private List<Producto> reservasDeProductos;
    private Cliente cliente;
    private double precioTotal;

    public Localizador(List<Producto> reservasDeProductos, Cliente cliente, double precioTotal) {
        this.reservasDeProductos = reservasDeProductos;
        this.cliente = cliente;
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "reservasDeProductos=" + reservasDeProductos +
                ", cliente=" + cliente +
                ", precioTotal=" + precioTotal +
                '}';
    }

    public List<Producto> getReservasDeProductos() {
        return reservasDeProductos;
    }

    public void setReservasDeProductos(List<Producto> reservasDeProductos) {
        this.reservasDeProductos = reservasDeProductos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
}
