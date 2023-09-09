package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Fiesta", "Ford", 1000));
        vehiculos.add(new Vehiculo("Focus", "Ford", 1200));
        vehiculos.add(new Vehiculo("Explorer", "Ford", 2500));
        vehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        vehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
        vehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        vehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        vehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        vehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
        vehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        vehiculos.add(new Vehiculo("Logan", "Renault", 950));

        Garage garage = new Garage(1, vehiculos);

        System.out.println("Lista ordenada por precio de menor a mayor:");

        garage.getVehiculos()
                .stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(vehiculo -> System.out.println(vehiculo.getMarca() + " " +
                        vehiculo.getModelo() + " " + vehiculo.getCosto()));

        System.out.println("\nLista ordenada por marca y precio:");
        garage.getVehiculos()
                .stream()
                .sorted((v1, v2) -> {
                    int comparacionMarca = v1.getMarca().compareTo(v2.getMarca());
                    if(comparacionMarca != 0){
                        return comparacionMarca;
                    }
                    else{
                        return Double.compare(v1.getCosto(), v2.getCosto());
                    }
                })
                .forEach(vehiculo -> System.out.println(vehiculo.getMarca() + " " +
                        vehiculo.getModelo() + " " + vehiculo.getCosto()));

        System.out.println("\nLista de vehículos con precio no mayor a 1000:");
        List<Vehiculo> vehiculosPrecioNoMayorA1000 = garage.getVehiculos()
                .stream()
                .filter(v -> v.getCosto() <= 1000)
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .collect(Collectors.toList());
        vehiculosPrecioNoMayorA1000.forEach(vehiculo -> System.out.println(vehiculo.getMarca() + " " +
                vehiculo.getModelo() + " " + vehiculo.getCosto()));

        System.out.println("\nLista de vehículos con precio igual o mayor a 1000:");
        List<Vehiculo> vehiculosPrecioMayorA1000 = garage.getVehiculos()
                .stream()
                .filter(v -> v.getCosto() >= 1000)
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .collect(Collectors.toList());
        vehiculosPrecioMayorA1000.forEach(vehiculo -> System.out.println(vehiculo.getMarca() + " " +
                        vehiculo.getModelo() + " " + vehiculo.getCosto()));


        double promedioPrecio = garage.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);

        System.out.println("\nEl precio promedio de los vehículos es " + Math.round(promedioPrecio * 100.0) / 100.0);
    }
}