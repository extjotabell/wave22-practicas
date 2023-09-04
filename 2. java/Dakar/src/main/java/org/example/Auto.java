package org.example;

public class Auto extends Vehiculo {
    public Auto(Double velocidad, Double aceleracion, Integer anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000.0, 4);
    }

    @Override
    public String toString() {
        return "Auto{} " + super.toString();
    }
}
