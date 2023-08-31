package org.example;

public class NoPerecedero extends Producto{
    private String tipo;

    public NoPerecedero(String name, double price, String tipo) {
        super(name, price);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "name='" + super.getName() + '\'' +
                ", price=" + super.getPrice() +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
