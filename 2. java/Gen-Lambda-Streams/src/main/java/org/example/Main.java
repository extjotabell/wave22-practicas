package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Renault", "Logan", 950);

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        vehiculos.add(vehiculo3);
        vehiculos.add(vehiculo4);
        vehiculos.add(vehiculo5);
        vehiculos.add(vehiculo6);
        vehiculos.add(vehiculo7);
        vehiculos.add(vehiculo8);
        vehiculos.add(vehiculo9);
        vehiculos.add(vehiculo10);
        vehiculos.add(vehiculo11);

        Garage garage = new Garage(1, vehiculos);
        garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);
        garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).sorted(Comparator.comparing(Vehiculo::getMarca)).forEach(System.out::println);
        List<Vehiculo> vMenorAMil = garage.getVehiculos().stream().filter(v -> v.getCosto() < 1000).collect(Collectors.toList());
        List<Vehiculo> vMayorOIgualAMil = garage.getVehiculos().stream().filter(v -> v.getCosto() >= 1000).collect(Collectors.toList());

        for (Vehiculo v :
                vMenorAMil) {
            System.out.println(v);
        }
        System.out.println("------------");
        for (Vehiculo v :
                vMayorOIgualAMil) {
            System.out.println(v);
        }

        double promedio = garage.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().orElse(0.0);
        System.out.println("Promedio precios vehiculos: "+promedio);
    }

}