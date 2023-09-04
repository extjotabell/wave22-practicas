package models;

public class Auto extends Vehiculo {

    public Auto(String patente, double velocidad, double aceleracion, double anguloDeGiro) {
        super(patente, velocidad, aceleracion, anguloDeGiro, 1000, 4);
    }
}
