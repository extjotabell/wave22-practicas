package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

        public class Main {
            public static void main(String[] args) {

                List<Vehiculo> listaVehiculos = new ArrayList<>();

                // Agregar los registros a la lista
                listaVehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
                listaVehiculos.add(new Vehiculo("Ford", "Focus", 1200));
                listaVehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
                listaVehiculos.add(new Vehiculo("Fiat", "Uno", 500));
                listaVehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
                listaVehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
                listaVehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
                listaVehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
                listaVehiculos.add(new Vehiculo("Toyota", "Corolla", 1200));
                listaVehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
                listaVehiculos.add(new Vehiculo("Renault", "Logan", 950));

                Garage nuevoGarage = new Garage();

                nuevoGarage.setId(1);
                nuevoGarage.setVehiculos(listaVehiculos);

                nuevoGarage.getVehiculos().stream()
                        .sorted((x,y) -> x.getCosto().compareTo(y.getCosto()) )
                        .forEach(System.out::println);

                System.out.println("-----------------------------------------");

                nuevoGarage.getVehiculos().stream()
                        .sorted((x,y) -> x.getCosto().compareTo(y.getCosto()))
                        .sorted((x,y) -> x.getMarca().compareTo(y.getMarca()))
                        .forEach(System.out::println);

                List<Vehiculo> cochesFiltrados = nuevoGarage.getVehiculos().stream()
                        .filter((x) -> x.getCosto() < 1000).collect(Collectors.toList());

                List<Vehiculo> cochesFiltrados2 = nuevoGarage.getVehiculos().stream()
                        .filter((x) -> x.getCosto() >= 1000).collect(Collectors.toList());

                System.out.println("-----------------------------------------");

                String promedio = nuevoGarage.getVehiculos().stream()
                        .mapToDouble(Vehiculo::getCosto).average().toString();

                System.out.printf(promedio) ;

            }
        }
