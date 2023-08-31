package org.example;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Producto producto1 = new Perecedero("Papas",100,3);
        Producto producto2 = new Perecedero("Zanahorias",200,2);
        Producto producto3 = new Perecedero("Remolacha",150,1);
        Producto producto4 = new NoPerecedero("Atun",400,"Enlatado");
        Producto producto5 = new NoPerecedero("Salsa Roja",350,"Tetrabrik");
        Distribuidora distribuidora = new Distribuidora();
        List<Producto> productos = distribuidora.getProductos();
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        double precioTotal = 0;
        for (Producto producto : productos) {
            precioTotal+=producto.calcular(5);
        }
        System.out.println("El precio total es de: $"+Math.round(precioTotal));
    }
}