//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

public class Vehiculo {
    private String modelo;
    private String marca;
    private Integer costo;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, int costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getCosto() {
        return this.costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String toString() {
        return "Vehiculo{modelo='" + this.modelo + "', marca='" + this.marca + "', costo=" + this.costo + "}";
    }
}
