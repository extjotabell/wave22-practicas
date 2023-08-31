package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
            Aspiradora atma = new AspiradoraInalambrica();
            Aspiradora philco = new AspiradoraConCable();

            EmpleadoLimpieza pepe = new EmpleadoLimpieza(123, "Pepe");

            pepe.limpiar(atma);

    }
}