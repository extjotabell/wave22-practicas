package org.example;

import org.example.models.Gato;
import org.example.models.Perro;
import org.example.models.Vaca;


public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        System.out.println(gato.emitirSonido());
        gato.comer();

        System.out.println(perro.emitirSonido());
        perro.comer();

        System.out.println(vaca.emitirSonido());
        vaca.comer();
    }
}