package org.example;

public class Main {
    public static void main(String[] args) {
        Persona iara = new Persona();
        Persona solange = new Persona("Solange", 30, "35756263");
        Persona luciana = new Persona("Luciana", 28, "38832625", 51, 1.54);

        int imcLuciana = luciana.calcularImc(luciana.peso, luciana.altura);
        boolean esMayor = luciana.esMayorDeEdad(luciana.edad);
        String mensaje = imcLuciana == 0 ? "Peso saludable" : imcLuciana == 1 ? "Tiene sobrepeso" : "Bajo peso";

        System.out.println("Usuaria luciana...");
        System.out.println(luciana.toString(luciana));
        System.out.println("Su resultado de IMC es..." + mensaje);
        System.out.println("Es mayor de edad..." + (esMayor ? "si" : "no"));
    }
}