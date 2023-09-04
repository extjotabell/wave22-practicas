package org.example;

public abstract class Vehiculo {

    private double velocidad;

    private double acelacion;

    private double anguloDeGiro;

    private String patente;

    private double peso;

    private int ruedas;

    public Vehiculo() {
    }

    public Vehiculo(double velocidad, double acelacion, double anguloDeGiro, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.acelacion = acelacion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAcelacion() {
        return acelacion;
    }

    public void setAcelacion(double acelacion) {
        this.acelacion = acelacion;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }
}
