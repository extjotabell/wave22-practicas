package org.example;

public class Aspiradora {
    private String marca;
    private String color;
    private double potencia;

    public Aspiradora(String marca, String color, double potencia) {
        this.marca = marca;
        this.color = color;
        this.potencia = potencia;
    }
    public Aspiradora(){
    }
    public String aspirar(){
        String mensaje = "Estoy aspirando";
        return mensaje;
    }
}
