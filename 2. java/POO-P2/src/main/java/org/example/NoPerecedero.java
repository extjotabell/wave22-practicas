package org.example;

public class NoPerecedero extends Producto{
    private String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo= tipo;
    }

    @Override
    public String toString() {
        return "NoPerecedero: " +
                "nombre: " + super.getNombre() +
                "precio: " + super.getPrecio() +
                "tipo: '" + tipo + '\'' +
                '}';
    }
}