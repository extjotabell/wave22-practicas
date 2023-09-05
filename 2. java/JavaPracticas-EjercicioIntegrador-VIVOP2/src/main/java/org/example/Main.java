package org.example;

import org.example.SaveTheRopa.Models.GuardaRopa;
import org.example.SaveTheRopa.Models.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //SAVE THE ROPA

        GuardaRopa nuevoGuardaRopa = new GuardaRopa();

        Prenda prenda1 = new Prenda("Bensimon", "Jean");
        Prenda prenda2 = new Prenda("Levis", "Remera");
        Prenda prenda3 = new Prenda("DonVintage", "Camisa");
        Prenda prenda4 = new Prenda("LaRambla", "Jogger");
        Prenda prenda5 = new Prenda("Pictur", "Musculosa");

        List<Prenda> listaRopa = new ArrayList<>();
        List<Prenda> listaRopa1 = new ArrayList<>();
        List<Prenda> listaRopa2 = new ArrayList<>();


        listaRopa.add(prenda1);
        listaRopa.add(prenda2);

        listaRopa1.add(prenda3);
        listaRopa1.add(prenda4);

        listaRopa2.add(prenda5);

        int num1 = nuevoGuardaRopa.guardarPrendas(listaRopa);
        int num2 = nuevoGuardaRopa.guardarPrendas(listaRopa1);
        int num3 = nuevoGuardaRopa.guardarPrendas(listaRopa2);

        System.out.println("-----------------------------------");

        nuevoGuardaRopa.mostrarPrendas();

        System.out.println("-----------------------------------");

        var lista1 = nuevoGuardaRopa.devolverPrendas(num1);

        for (var prenda: lista1) {
            System.out.println(prenda);
        }

        System.out.println("-----------------------------------");

        var lista2 = nuevoGuardaRopa.devolverPrendas(num2);

        for (var prenda: lista2) {
            System.out.println(prenda);
        }

        System.out.println("-----------------------------------");

        var lista3 = nuevoGuardaRopa.devolverPrendas(num3);

        for (var prenda: lista3) {
            System.out.println(prenda);
        }

        System.out.println("-----------------------------------");

        //--------------------------------------------------------

        //DAKAR



    }
}