package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> prendaList = new ArrayList<>();

        prendaList.add(new Prenda("Marca1", "Modelo1"));
        prendaList.add(new Prenda("Marca2", "Modelo2"));

        guardaRopa.guardarPrendas(prendaList);

        guardaRopa.mostrarPrendas();
    }
}