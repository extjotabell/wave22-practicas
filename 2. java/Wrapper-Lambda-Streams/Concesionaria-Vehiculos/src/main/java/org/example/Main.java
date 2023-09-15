package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>(List.of(
                new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Fiat", "Cronos", 1000),
                new Vehiculo("Fiat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Corolla", 1200),
                new Vehiculo("Toyota", "Fortuner", 3000),
                new Vehiculo("Renault", "Logan", 950)
        ));

        Garaje nuevoGarage = new Garaje(1, listaVehiculos);

        nuevoGarage
                .getListaVehiculos()
                .stream()
                .sorted((x, y) -> x.getCosto().compareTo((y.getCosto())))
                .forEach(System.out::println);

        nuevoGarage
                .getListaVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        List<Vehiculo> vehiculosPrecioNoMayorA100 =
                nuevoGarage
                        .getListaVehiculos()
                        .stream()
                        .filter(vehiculo -> vehiculo.getCosto() <= 100)
                        .;


    }
}