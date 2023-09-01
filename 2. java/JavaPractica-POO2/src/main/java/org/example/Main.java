package org.example;

public class Main {
    public static void main(String[] args) {

        Distribuidora distribuidora = new Distribuidora();

        Producto producto1 = new NoPerecedero("Luchetti", 500, "Fideos");
        Producto producto2 = new NoPerecedero("Terrabusi", 600, "Fideos");
        Producto producto3 = new NoPerecedero("Knor", 400, "Fideos");
        Producto producto4 = new NoPerecedero("Matarazzo", 200, "Fideos");
        Producto producto5 = new NoPerecedero("Pepito", 350, "Fideos");

        Producto producto6 = new Perecedero("Carne", 200, 1);
        Producto producto7 = new Perecedero("Fiambre", 300, 2);
        Producto producto8 = new Perecedero("Queso", 750, 5);
        Producto producto9 = new Perecedero("Yogurt", 900, 3);
        Producto producto10 = new Perecedero("Manteca", 800, 7);

        distribuidora.addProducto(producto1);
        distribuidora.addProducto(producto2);
        distribuidora.addProducto(producto3);
        distribuidora.addProducto(producto4);
        distribuidora.addProducto(producto5);
        distribuidora.addProducto(producto7);

        System.out.println(distribuidora.imprimirPrecioTotal());
        System.out.println(distribuidora.imprimirPrecioPorTipo());

    }
}