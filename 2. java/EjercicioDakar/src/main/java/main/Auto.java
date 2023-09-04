package main;

public class Auto extends Vehiculo {

    public Auto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        super.ruedas = 4;
        super.peso = 1000;
    }
}
