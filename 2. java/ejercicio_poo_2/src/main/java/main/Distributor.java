package main;

import java.util.ArrayList;
import java.util.List;

public class Distributor {
    public static void main(String[] args) {
        List<Producto> products = new ArrayList<>();

        products.add(new Perecedero("carne",150,1));
        products.add(new Perecedero("carne",150,1));
        products.add(new Perecedero("carne",150,2));
        products.add(new Perecedero("carne",150,2));
        products.add(new Perecedero("carne",150,3));

        products.add(new NoPerecedero("arroz",1500,"tipo"));
        products.add(new NoPerecedero("arroz",1500,"tipo"));
        products.add(new NoPerecedero("arroz",1500,"tipo"));
        products.add(new NoPerecedero("arroz",1500,"tipo"));
        products.add(new NoPerecedero("arroz",1500,"tipo"));

        double total = 0;

        for (Producto p : products) {
           total += p.calcular(5);
        }

        System.out.println(total);
    }



}
