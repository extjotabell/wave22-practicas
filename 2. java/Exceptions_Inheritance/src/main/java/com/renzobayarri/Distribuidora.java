package com.renzobayarri;

public class Distribuidora {

    public static void main(String[] args) {
        Producto[] productos = new Producto[3];

        productos[0] = new Perecedero("Leche", 400, 3);
        productos[1] = new NoPerecedero("Jabón", 100, "Limpieza");
        productos[2] = new Perecedero("Queso", 700,1);

        for (int i = 0; i < productos.length; i++) {
            System.out.println("Nombre: " + productos[i].getNombre());
            System.out.println("Precio: " + productos[i].getPrecio());
            System.out.println("Cantidad: " + 5);
            System.out.println("Precio total: " + productos[i].calcular(5));
        }
    }
}
