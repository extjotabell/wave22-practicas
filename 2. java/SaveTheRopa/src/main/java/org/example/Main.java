package org.example;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Adidas", "Remera");
        Prenda prenda2 = new Prenda("Lacoste", "Chomba");

        Prenda prenda3 = new Prenda("Hamilton's", "Saco");


        GuardaRopa guardaRopa1 = new GuardaRopa();

        List<Prenda> listaPrendas = new ArrayList<>();
        listaPrendas.add(prenda1);
        listaPrendas.add(prenda2);

        List<Prenda> listaPrendasNueva = new ArrayList<>();
        listaPrendasNueva.add(prenda3);

        int numeroRecibido = guardaRopa1.guardarPrendas(listaPrendas);
        guardaRopa1.guardarPrendas(listaPrendasNueva);

        guardaRopa1.mostrarPrendas();

        System.out.println(guardaRopa1.devolverPrendas(numeroRecibido).toString());
    }
}