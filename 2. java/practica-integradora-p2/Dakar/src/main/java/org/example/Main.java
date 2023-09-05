package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Carrera carrera = new Carrera(10,1000,"Carrera jeje",2);

        carrera.darDeAltaAuto(150,0.9,3,"ABC123");
        carrera.darDeAltaAuto(151,0.9,3,"SSS123");
        carrera.darDeAltaAuto(152,0.9,3,"ZZZ123");

        carrera.eliminarVehiculoConPatente("ABC123");
        System.out.println(carrera);

        carrera.socorrerAuto("SSS123");


    }
}