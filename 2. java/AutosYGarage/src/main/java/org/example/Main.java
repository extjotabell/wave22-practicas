package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo( "Ford","Fiesta", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Ford","Focus",  1200);
        Vehiculo vehiculo3 = new Vehiculo( "Ford","Explorer", 2500);
        Vehiculo vehiculo4 = new Vehiculo( "Fiat", "Uno",500);
        Vehiculo vehiculo5 = new Vehiculo( "Fiat", "Cronos",1000);
        Vehiculo vehiculo6 = new Vehiculo( "Fiat", "Torino",1250);
        Vehiculo vehiculo7 = new Vehiculo( "Chevrolet", "Aveo",1250);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Corolla", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Toyota","Fortuner",  3000);
        Vehiculo vehiculo11 = new Vehiculo("Renault", "Logan", 950);

        List<Vehiculo> listaDeVehiculos = new ArrayList<>();
        listaDeVehiculos.add(vehiculo1);
        listaDeVehiculos.add(vehiculo2);
        listaDeVehiculos.add(vehiculo3);
        listaDeVehiculos.add(vehiculo4);
        listaDeVehiculos.add(vehiculo5);
        listaDeVehiculos.add(vehiculo6);
        listaDeVehiculos.add(vehiculo7);
        listaDeVehiculos.add(vehiculo8);
        listaDeVehiculos.add(vehiculo9);
        listaDeVehiculos.add(vehiculo10);
        listaDeVehiculos.add(vehiculo11);

        Garage garage1 = new Garage("A", listaDeVehiculos);

        //garage1.mostrarListaOrdenadaPorPrecio();
        //garage1.mostrarListaOrdenadaPorMarcaYPrecio();
        System.out.println("MenoresOIgualesA: 1000");
        System.out.println(garage1.retornarMenoresOIgualesA(1000));
        System.out.println("MayoresOIgualesA: 1000");
        System.out.println(garage1.retornarMayoresOIgualesA(1000));
        System.out.println("Promedio: " + garage1.promedioDePrecios());
    }
}