package org.example;

public class Producto {
    protected String nombre;
    protected double precio;

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio ;
    }


    public double calcular(int cantidadProductos){
        return cantidadProductos*precio;
    }

}