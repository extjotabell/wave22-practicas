package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Prenda p1 = new Prenda("Nike", "Buzo Icon");
        Prenda p2 = new Prenda("Adidas", "Superstar");
        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> prendas = new ArrayList<>();
        prendas.add(p1);
        prendas.add(p2);
        Integer codigo = guardaRopa.guardarPrendas(prendas);
        guardaRopa.mostrarPrendas();
        List<Prenda> consultaPrendas = guardaRopa.devolverPrendas(codigo);
        System.out.println(consultaPrendas.toString());
        Integer codigo2 = guardaRopa.guardarPrendas(prendas);
        guardaRopa.mostrarPrendas();
        List<Prenda> consultaPrendas2 = guardaRopa.devolverPrendas(codigo2);
        System.out.println(consultaPrendas2.toString());
    }
}
