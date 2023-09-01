package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Animal gato = new Gato();
        Animal perro = new Perro();
        Animal vaca = new Vaca();

        gato.emitirSonido();
        gato.comer();

        perro.emitirSonido();
        perro.comer();

        vaca.emitirSonido();
        vaca.comer();

    }
}