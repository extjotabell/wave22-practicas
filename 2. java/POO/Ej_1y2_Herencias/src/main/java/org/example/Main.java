package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Producto arvejas =  new Producto("Arvejas",50);
        Producto arroz =  new Perecedero("Arroz",100, 1);

        System.out.println(arroz.calcular(10));
        System.out.println(arvejas.calcular(10));

    }
}