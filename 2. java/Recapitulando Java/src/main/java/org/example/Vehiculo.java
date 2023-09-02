package org.example;

import java.util.Optional;

public class Vehiculo {
    private String modelo;
    private String marca;
    private Double costo;
    private double total = 0;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        if (this.total == 0) { this.total = costo;}
        this.total += total;
    }

    public Vehiculo(String modelo, String marca, double costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                '}';
    }
}
