package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa(1);
        List<Prenda> prendas = new ArrayList<>();
        prendas.add(new Prenda("Nike", "Air Max"));
        prendas.add(new Prenda("Versace", "Star Boy"));

        System.out.println("Tu código para retirar tus prendas es: " + guardaRopa.guardarPrendas(prendas));
        guardaRopa.mostrarPrendas();

    }
}