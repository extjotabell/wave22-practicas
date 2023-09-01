package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Ford","Fiesta",1000));
        vehiculos.add(new Vehiculo("Ford","Focus",1200));
        vehiculos.add(new Vehiculo("Ford","Explorer",2500));
        vehiculos.add(new Vehiculo("Fiat","Uno",500));
        vehiculos.add(new Vehiculo("Fiat","Cronos",1000));
        vehiculos.add(new Vehiculo("Fiat","Torino",1250));
        vehiculos.add(new Vehiculo("Chevrolet","Aveo",1250));
        vehiculos.add(new Vehiculo("Chevrolet","Spin",2500));
        vehiculos.add(new Vehiculo("Toyota","Corola",1200));
        vehiculos.add(new Vehiculo("Toyota","Fortuner",100));
        vehiculos.add(new Vehiculo("Ford","Fiesta",100));

        Garaje garaje = new Garaje(1,vehiculos);

        System.out.println("---------EJERCICIO 3----------------");

        garaje.getVehiculos().stream()
                             .sorted(Comparator.comparing(Vehiculo::getPrecio))
                             .forEach(System.out::println);

        System.out.println();
        System.out.println();

        System.out.println("------------EJERCICIO 4--------------");

        garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getPrecio))
                .forEach(System.out::println);

        System.out.println();
        System.out.println();
        System.out.println("--------EJERCICIO 5-------------------");
        List<Vehiculo> menor = garaje.getVehiculos().stream()
                .filter(v -> v.getPrecio() < 1000).collect(Collectors.toList());

        System.out.println();
        List<Vehiculo> mayor = garaje.getVehiculos().stream()
                .filter(v -> v.getPrecio() >= 1000).collect(Collectors.toList());

        Double promedio = garaje.getVehiculos().stream()
                .mapToDouble(Vehiculo::getPrecio)
                .average()
                .orElse(0.0);

        mayor.forEach(System.out::println);
        System.out.println();
        menor.forEach(System.out::println);
        System.out.println();
        System.out.println(promedio);

    }




}
