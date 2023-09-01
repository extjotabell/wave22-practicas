package main;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        Producto p1 = new Perecedero("Leche entera", 400, 3);
        Producto p2 = new Perecedero("Leche descremada", 200, 6);
        Producto p3 = new Perecedero("Crema", 600, 5);
        Producto p4 = new Perecedero("Yogur", 2000, 2);
        Producto p5 = new Perecedero("Arroz",500, 7);

        Producto p6 = new NoPerecedero("Tallarines", 400, "Fideos");
        Producto p7 = new NoPerecedero("Fideos moño", 200, "Fideos");
        Producto p8 = new NoPerecedero("Lentejas", 600, "Legumbres");
        Producto p9 = new NoPerecedero("Porotos", 2000, "Legumbres");
        Producto p10 = new NoPerecedero("Arroz",500, "Arroz");

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);
        productos.add(p6);
        productos.add(p7);
        productos.add(p8);
        productos.add(p9);
        productos.add(p10);

        double suma = 0;
        for(Producto p: productos) {
            suma += p.calcular(1);
        }
        System.out.println("Precio total: "+suma);
    }
}
