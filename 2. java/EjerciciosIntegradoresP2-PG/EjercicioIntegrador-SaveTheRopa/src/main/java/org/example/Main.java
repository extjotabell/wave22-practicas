package org.example;

import models.GuardarRopa;
import models.Prenda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Prenda> guardarprendas1 = List.of(
                new Prenda("Levis", "LEVIS231"),
                new Prenda("Converse", "RemeraConverse")
                );

        List<Prenda> guardarprendas2 = List.of(
                new Prenda("47", "Campera"),
                new Prenda("Adidas", "Zapatillas")
        );

        GuardarRopa guardandRopa = new GuardarRopa();
        System.out.println("Guardando prendas, codigo de identificacion: " + guardandRopa.guardarPrendas(guardarprendas1));
        System.out.println("Guardando prendas, codigo de identificacion: " + guardandRopa.guardarPrendas(guardarprendas2));

        guardandRopa.mostrarPrendas();
        System.out.println(guardandRopa.devolverPrendas(2));
    }
}