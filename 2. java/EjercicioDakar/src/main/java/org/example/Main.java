package org.example;

import org.example.clases.Carrera;
import org.example.clases.Vehiculo;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Carrera carrera = new Carrera(200.0,100000.0,"Dakar", 5);

        carrera.darDeAltaAuto(100, 20, 24.5, "AFJ231");
        carrera.darDeAltaAuto(120, 10, 14.5, "ACD132");
        carrera.darDeAltaAuto(90, 30, 34.5, "ZBJ433");
        carrera.darDeAltaMoto(90, 30, 34.5, "JKS489");
        carrera.darDeAltaMoto(90, 30, 31.5, "SLD392");

        carrera.socorrerAuto("AFJ231");
        carrera.socorrerMoto("SLD392");


        Vehiculo vehiculo = carrera.definirGanador();

        System.out.println(vehiculo);

        carrera.eliminarVehiculo(vehiculo);


        System.out.println(carrera.definirGanador());

        carrera.eliminarVehiculoConPatente("JKS489");

        System.out.println(carrera.definirGanador());

    }
}