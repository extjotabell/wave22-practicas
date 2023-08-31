package org.example;

public class Distribuidora {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Producto[] productos = new Producto[5];

        Producto atun = new NoPrecedero("atun", 1990, "lata");
        Producto tallarines = new NoPrecedero("atun", 1990, "envasado");
        Producto jamon = new NoPrecedero("jamon", 1990, "envasado");
        Producto jabon = new Producto("jabon", 1990);
        Producto papel = new Producto("papel", 1990);

        productos[0] = atun;
        productos[1] = tallarines;
        productos[2] = jamon;
        productos[3] = jabon;
        productos[4] = papel;

        for (Producto producto : productos) {
            double cantidadPagar = producto.calcular(5);
            System.out.println("Producto " + producto.getNombre() + " cantidad a pagar: " + cantidadPagar);
        }

        System.out.println(productos[0].getNombre());

    }
}