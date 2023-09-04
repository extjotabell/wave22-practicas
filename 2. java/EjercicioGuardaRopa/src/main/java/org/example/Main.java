package org.example;

import org.example.clases.GuardaRopa;
import org.example.clases.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Adidas","UnModelo");
        Prenda prenda2 = new Prenda("Nike","Air");
        List<Prenda> prendas = new ArrayList<>();
        prendas.add(prenda1);
        prendas.add(prenda2);
        GuardaRopa guardaRopa = new GuardaRopa();
        guardaRopa.guardarPrendas(prendas);
        guardaRopa.mostrarPrendas();
        guardaRopa.devolverPrendas(0);
        guardaRopa.mostrarPrendas();
    }
}