package org.example;

public class Distribuidora {
    public static void main(String[] args) {

        Producto[] listaDeProductos = new Producto[5];
        listaDeProductos[0] = new Perecedero("leche",300,1);
        listaDeProductos[1] = new Perecedero("huevos",700,2);
        listaDeProductos[2] = new Perecedero("banana",400,3);
        listaDeProductos[3] = new NoPerecedero("cafe",800, "bebidas");
        listaDeProductos[4] = new Perecedero("azucar",600,6);

        double resultado = 0;

        for (Producto prod: listaDeProductos) {
            resultado += prod.calcular(5);
        }
        System.out.println(resultado);

    }

}