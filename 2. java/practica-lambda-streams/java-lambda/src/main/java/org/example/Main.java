package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> listaDeVehiculos = new ArrayList<>();
        listaDeVehiculos.add(new Vehiculo("Ford","Fiesta", 1000));
        listaDeVehiculos.add(new Vehiculo("Ford","Focus", 1200));
        listaDeVehiculos.add(new Vehiculo("Ford","Explorer", 2500));
        listaDeVehiculos.add(new Vehiculo("Fiat","Uno", 500));
        listaDeVehiculos.add(new Vehiculo("Fiat","Cronos", 1000));
        listaDeVehiculos.add(new Vehiculo("Fiat","Torino", 1250));
        listaDeVehiculos.add(new Vehiculo("Chevrolet","Aveo", 1250));
        listaDeVehiculos.add(new Vehiculo("Chevrolet","Spin", 2500));
        listaDeVehiculos.add(new Vehiculo("Toyota","Corola", 1200));
        listaDeVehiculos.add(new Vehiculo("Toyota","Fortuner", 3000));
        listaDeVehiculos.add(new Vehiculo("Renault","Logan", 950));

        Garaje garaje1 = new Garaje(1,listaDeVehiculos);

        //ejercicio 3
        List<Vehiculo> nuevoLista = garaje1.getVehiculos();
        nuevoLista.sort(Comparator.comparing(Vehiculo::getCosto));
        nuevoLista.forEach(System.out::println);
        System.out.println("-------");

        //ejercicio 4
        nuevoLista.sort(Comparator.comparing(Vehiculo::getMarca));
        nuevoLista.forEach(System.out::println);
        System.out.println("-------");

        //ejeercicio 5
        List<Vehiculo> vehiculos = garaje1.getVehiculos();
        vehiculos.stream().filter(x -> x.getCosto() <= 1000).forEach(System.out::println);
        List<Vehiculo>  vehiculosBaratos =  vehiculos.stream().filter(x -> x.getCosto() < 1000).collect(Collectors.toList());
        List<Vehiculo>  vehiculosCaros =  vehiculos.stream().filter(x -> x.getCosto() >= 1000).collect(Collectors.toList());
        double promedio = vehiculos.stream().mapToInt(Vehiculo::getCosto).average().orElse(0);
        System.out.println(promedio);

    }
}