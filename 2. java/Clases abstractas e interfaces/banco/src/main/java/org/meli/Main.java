package org.meli;

public class Main {
    public static void main(String[] args) {
        Ejecutivo ejec1 = new Ejecutivo();
        ejec1.realizarTransaccion(new ConsultaSaldo());
        ejec1.realizarTransaccion(new Deposito());
    }
}