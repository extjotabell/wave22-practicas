package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("cual es tu nombre?");
        String nombre = input.next();
        System.out.println("cual es tu apellido?");
        String apellido = input.next();
        System.out.println("cual es tu DNI?");
        long dni = input.nextLong();
        System.out.println("cuantos años tenes?");
        int edad = input.nextInt();
        System.out.println("que carrera estudias?");
        String carrera = input.next();



    }


}