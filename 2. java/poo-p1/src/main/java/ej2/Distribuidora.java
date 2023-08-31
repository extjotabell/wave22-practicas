package ej2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        Producto producto1 = new NoPerecedero("Arroz", 50, "cereal");
        Producto producto2 = new Perecedero("Leche", 150, 2);
        Producto producto3 = new NoPerecedero("Agua", 30, "bebida");
        Producto producto4 = new NoPerecedero("Fideos", 80, "pastas secas");
        Producto producto5 = new Perecedero("Helado", 1000, 3);

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        for (Producto p : productos) {
            double total = p.calculate(5);
            System.out.println(p + " total de productos: " + total);
        }

    }
}