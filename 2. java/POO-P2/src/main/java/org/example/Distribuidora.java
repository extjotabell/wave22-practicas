package org.example;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos= new ArrayList<>();
        productos.add(new Perecedero("queso",100.00,5));
        productos.add(new Perecedero("queso cremoso",100.00,1));
        productos.add(new Perecedero("queso crema",100.00,2));
        productos.add(new Perecedero("queso rallado",100.00,3));
        productos.add(new Perecedero("queso roquefort",100.00,4));
        productos.add(new NoPerecedero("arvejas",100.0,"enlatado"));
        productos.add(new NoPerecedero("arroz",100.0,"grano"));
        productos.add(new NoPerecedero("fideos",100.0,"pastas"));
        productos.add(new NoPerecedero("polenta",100.0,"maiz"));
        productos.add(new NoPerecedero("lentejas",100.0,"legumbres"));

        double precioTotal=0.0;

        for (Producto producto : productos) {
            precioTotal+= producto.calcular(1);
        }
        System.out.println("Precio total: " + precioTotal);

    }
}