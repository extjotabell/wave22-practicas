package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Ejercicio 1
        /*int[] lista = new int[6];
        lista[0] = 5;
        lista[1] = 8;
        lista[2] = 3;
        lista[3] = 1;
        lista[4] = 9;
        lista[5] = 7;

        System.out.println(Arrays.toString(Ejercicio1.burbuja(lista)))*/

        // Ejercicio Clases Abstractas
        Prototipo prototipo = new Prototipo();

        System.out.println(prototipo.siguiente());
        System.out.println(prototipo.siguiente());
        System.out.println(prototipo.siguiente());
        System.out.println(prototipo.siguiente());
        prototipo.reiniciar();
        prototipo.inicio(2);
        System.out.println("------");
        System.out.println(prototipo.siguiente());
        System.out.println(prototipo.siguiente());
        System.out.println(prototipo.siguiente());
        System.out.println(prototipo.siguiente());
        prototipo.reiniciar();
        prototipo.inicio(3);
        System.out.println("------");
        System.out.println(prototipo.siguiente());
        System.out.println(prototipo.siguiente());
        System.out.println(prototipo.siguiente());
        System.out.println(prototipo.siguiente());



    }
}