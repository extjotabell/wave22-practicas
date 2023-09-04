package org.example;


public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(125.0, 125, "pepe", 3);

        Auto auto = new Auto(1.0,1.0,5, "789");
        carrera.darDeAltaAuto(12.0, 12.0, 10, "123");
        carrera.darDeAltaMoto(12.0, 12.0, 10, "456");
        carrera.darDeAltaAuto(1.0,1.0,5, "789");

        System.out.println(carrera.getListaDeVehiculos());

        carrera.eliminarVehiculo("789");

        System.out.println(carrera.getListaDeVehiculos());

        carrera.darDeAltaAuto(1.0,1.0,5, "789");
        carrera.eliminarVehiculo(auto);

        System.out.println(carrera.getListaDeVehiculos());

        carrera.socorrerAuto("123");
        carrera.socorrerMoto("123");

        carrera.correr();

    }
}