package org.example;

public class NoPerecedero extends Producto{
    public String tipo;

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        tipo = this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }

}