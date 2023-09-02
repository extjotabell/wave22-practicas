package org.example;
import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {
        List<Producto> productos = getProductos();

        double precioTotal = 0;

        for (Producto prod : productos) {
            precioTotal += prod.calcular(5);
        }

        System.out.println("precioTotal = " + precioTotal);
        System.out.println("Assert precioTotal equals manual calculation: "
                + String.valueOf(precioTotal == (900 * 5 + (double) (2400 * 5) / 3 + 1500 * 5 + (double) (4000 * 5) / 4 + 1000 * 5)));

    }

    private static List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<>();

        Producto producto1 = new NoPerecedero("Arroz", 900, "Grano");
        Producto producto2 = new Perecedero("Huevos", 2400, 2);
        Producto producto3 = new NoPerecedero("Lentejas", 1500, "Legumbre");
        Producto producto4 = new Perecedero("Carne", 4000, 1);
        Producto producto5 = new NoPerecedero("Atun", 1000, "Pescado");

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        return productos;
    }
}
