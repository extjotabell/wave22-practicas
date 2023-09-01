package com.renzobayarri.ejercicio1;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Garage garage = new Garage();

        garage.setId(1);
        garage.getVehiculos().add(new Vehiculo("Fiesta", "Ford", 1000));
        garage.getVehiculos().add(new Vehiculo("Focus", "Ford", 1200));
        garage.getVehiculos().add(new Vehiculo("Explorer", "Ford", 2500));
        garage.getVehiculos().add(new Vehiculo("Uno", "Fiat", 500));
        garage.getVehiculos().add(new Vehiculo("Cronos", "Fiat", 1000));
        garage.getVehiculos().add(new Vehiculo("Torino", "Fiat", 1250));
        garage.getVehiculos().add(new Vehiculo("Aveo", "Chevrolet", 1250));
        garage.getVehiculos().add(new Vehiculo("Spin", "Chevrolet", 2500));
        garage.getVehiculos().add(new Vehiculo("Corolla", "Toyota", 1200));
        garage.getVehiculos().add(new Vehiculo("Fortuner", "Toyota", 3000));
        garage.getVehiculos().add(new Vehiculo("Logan", "Renault", 950));

        garage.getVehiculos().stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(System.out::println);

        garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto))
                .forEach(System.out::println);

        List<Vehiculo> vehiculosMenores1000 = garage.getVehiculos().stream()
                .filter(v -> v.getCosto() < 1000)
                .toList();

        List<Vehiculo> vehiculosMayores1000 = garage.getVehiculos().stream()
                .filter(v -> v.getCosto() >= 1000)
                .toList();

        double average = garage.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElseThrow(() -> new RuntimeException("Error"));

        System.out.println(average);

    }
}