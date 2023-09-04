package org.example;

public class Item {
    private String nombre;
    private double monto;

    public Item(String nombre, double monto) {
        this.nombre = nombre;
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getMonto() {
        return monto;
    }


}
