package org.example;

public class SocorristaMoto extends Vehiculo{
    public SocorristaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente, double peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    public static void socorrer(Moto moto){
        System.out.println("Socorriendo moto: " + moto.getPatente());
    }
}
