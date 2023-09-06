package model;

import model.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reserva {

    private ArrayList<Producto> productos; // Lista de productos en la reserva
    private double total;
    public Reserva() {
        this.total = 0.0;
        this.productos = new ArrayList<>();
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double calcularTotal() {
        // Calcular el total de la reserva sumando los precios de los productos
        return productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
    }

    private void actualizarTotal() {
        total = calcularTotal();
    }
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        total += calcularTotal(); // Actualizamos el total al agregar un producto
    }

    @Override
    public String toString() {
        return "Reserva{" +
                ", productos=" + productos +
                ", total=" + total +
                '}';
    }


}
