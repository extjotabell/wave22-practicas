package org.example.Productos;

public abstract class Producto {
    double precio;

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto(double precio) {
        this.precio = precio;


    }
}
