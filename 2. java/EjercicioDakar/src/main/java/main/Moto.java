package main;

public class Moto extends Vehiculo {

    public Moto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        super.ruedas = 2;
        super.peso = 300;
    }
}
