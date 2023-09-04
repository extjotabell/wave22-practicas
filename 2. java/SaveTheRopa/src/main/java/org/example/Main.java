package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(new Prenda("Marca 1", "Modelo 1"));
        prendas.add(new Prenda("Marca 2", "Modelo 2"));

        Integer id = guardaRopa.guardarPrendas(prendas);
        guardaRopa.mostrarPrendas();
        List<Prenda> devueltas = guardaRopa.devolverPrendas(id);
        guardaRopa.mostrarPrendas();


    }
}