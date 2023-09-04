package org.example;

import org.example.Prendas.Pantalon;
import org.example.Prendas.Prenda;
import org.example.Prendas.Remera;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda1 = new Remera("adidas", "musculosa");
        Prenda prenda2 = new Pantalon("levis", "chupin");

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(prenda1);
        prendas.add(prenda2);

        Prenda prenda3 = new Remera("zara", "blusa");
        Prenda prenda4 = new Pantalon("levis", "short");

        List<Prenda> prendas2 = new ArrayList<>();
        prendas2.add(prenda3);
        prendas2.add(prenda4);

        int storageNumber = guardaRopa.guardarPrendas(prendas);
        System.out.println("Guardaste tu ropa. Consulta su estado con tu id: "+storageNumber);
        int storageNumber2 = guardaRopa.guardarPrendas(prendas2);
        System.out.println("Guardaste tu ropa. Consulta su estado con tu id: "+storageNumber2);
        guardaRopa.mostrarPrendas();
        var ropa = guardaRopa.devolverPrendas(1);
        System.out.println(ropa);

    }
}