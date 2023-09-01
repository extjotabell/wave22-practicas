package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> listaDeVehiculos = new ArrayList<>();

        // Instanciar vehiculos y agregar a la lista
        listaDeVehiculos.add(new Vehiculo( "Ford","Fiesta", 1000));
        listaDeVehiculos.add(new Vehiculo("Ford","Focus",  1200));
        listaDeVehiculos.add(new Vehiculo( "Ford","Explorer", 2500));
        listaDeVehiculos.add(new Vehiculo( "Fiat", "Uno",500));
        listaDeVehiculos.add(new Vehiculo( "Fiat", "Cronos",1000));
        listaDeVehiculos.add(new Vehiculo( "Fiat", "Torino",1250));
        listaDeVehiculos.add(new Vehiculo( "Chevrolet", "Aveo",1250));
        listaDeVehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        listaDeVehiculos.add(new Vehiculo("Toyota", "Corolla", 1200));
        listaDeVehiculos.add(new Vehiculo("Toyota","Fortuner",  3000));
        listaDeVehiculos.add(new Vehiculo("Renault", "Logan", 950));

        // Instanciar garage
        Garage garage1 = new Garage("A", listaDeVehiculos);

        // Output:

        System.out.println("\n");
        System.out.println("Lista Ordenadas por precio ASC ");
        garage1.mostrarListaOrdenadaPorPrecio();

        System.out.println("\n");
        System.out.println("Lista Ordenadas por Marca y Precio ASC");
        garage1.mostrarListaOrdenadaPorMarcaYPrecio();

        System.out.println("\n");
        System.out.println("MenoresOIgualesA: 1000");
        System.out.println(garage1.retornarMenoresOIgualesA(1000));

        System.out.println("\n");
        System.out.println("MayoresOIgualesA: 1000");
        System.out.println(garage1.retornarMayoresOIgualesA(1000));

        System.out.println("\n");
        System.out.println("Promedio: " + garage1.promedioDePrecios());
    }
}