package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("--------Contando con 3-------");
        ContadorX3 contamosX3 = new ContadorX3();
        contamosX3.NextTo();
        contamosX3.NextTo();
        contamosX3.initialValue();

        System.out.println("--------Contando con 2-------");
        Contadorx2 contadorx2 = new Contadorx2();
        contadorx2.NextTo();
        contadorx2.NextTo();
        contadorx2.reboot();


    }
}