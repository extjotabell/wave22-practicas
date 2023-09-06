package org.example;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Alejandro", 21, "43561328");
        Persona persona3 = new Persona("Taylor", 33, "32187394", 55.4f, 1.80f);

        System.out.println("IMC de " + persona3.nombre + ": " + persona3.calcularIMC());
        System.out.println("Es mayor de edad? " + persona3.esMayorDeEdad());
        System.out.println();
        System.out.println(persona3.toString());
    }
}