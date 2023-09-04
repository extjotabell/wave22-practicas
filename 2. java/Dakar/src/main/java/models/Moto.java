package models;

public class Moto extends Vehiculo {

    public Moto(String patente, double velocidad, double aceleracion, double anguloDeGiro) {
        super(patente, velocidad, aceleracion, anguloDeGiro, 300, 2);
    }
}
