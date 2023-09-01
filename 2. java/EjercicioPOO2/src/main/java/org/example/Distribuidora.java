package org.example;

public class Distribuidora {
    public static void main(String[] args)
    {
        Producto[] productos = new Producto[4];
        productos[0] = new Perecedero("Carne", 23.99, 2);
        productos[1] = new NoPerecedero("Lenteja",  23.23, "Lenteja");
        productos[2] = new Perecedero("Pescado", 32.99, 6);
        productos[3] = new NoPerecedero("Arroz", 13.23, "Arroz");

        int cantidadAVender = 5;

        double precioTotal = 0;
        for (Producto producto : productos) {
            double precioProducto = producto.calcular(cantidadAVender);
            System.out.println("Precio total de " + cantidadAVender + " " + producto.getNombre() + ": $" + precioProducto);
            precioTotal += precioProducto;
        }
        System.out.print("Precio total de venta: $"+precioTotal);
    }
}
