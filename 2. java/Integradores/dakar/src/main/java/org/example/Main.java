package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("Preparando la carrera...");
        Carrera carrera = new Carrera(100.0, 1000, "Carrera Dakar", 5);
        System.out.println();
        System.out.println("Dando de alta vehiculos...");
        Auto auto = new Auto(300.0, 180.0, 180.0, "DSFKP87", 1000.0, 4);
        Moto moto = new Moto(200.0, 150.0, 90.0, "ASK902", 300.0, 2);
        carrera.darDeAltaMoto(moto);
        carrera.darDeAltaAuto(auto);
        carrera.darDeAltaAuto(new Auto(100.0, 120.0, 45.0, "ASDSD77", 1000.0, 4));
        carrera.darDeAltaMoto(new Moto(300.0, 100.0, 350.0, "OSK403", 300.0, 2));
        System.out.println();
        System.out.println("Llegan los socorristas...");
        carrera.setSocorristaMoto(new SocorristaMoto());
        carrera.setSocorristaAuto(new SocorristaAuto());
        carrera.getSocorristaAuto().socorrerAuto(auto);
        carrera.getSocorristaMoto().socorrerMoto(moto);
        System.out.println();
        System.out.println("Determinando ganador...");
        Optional<Vehiculo> ganador = carrera.determinarGanador(carrera.getListaDeVehiculos());
        System.out.println("El ganador fue el vehiculo " + ganador.get().getPatente());
    }
}