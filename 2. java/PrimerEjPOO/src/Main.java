package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Persona Santi = new Persona();
        Persona Cami = new Persona("Cami", "59564375", 15);
        Persona Randy = new Persona("Randy", "39756473", 30, 150, 1.89);
        // Persona errorPersona = new Persona("Cosme", 85);

        double resultadoIMC = Randy.calcularIMC();
        String IMCMessage = "";
        if (resultadoIMC == 0 ) {
            IMCMessage = "Peso saludable";
        } else if (resultadoIMC == -1) {
            IMCMessage = "Bajo peso";
        } else if (resultadoIMC == 1){
            IMCMessage = "Sobrepeso";
        }


        System.out.println("Randy tiene " + IMCMessage);
        if (Randy.esMayorDeEdad()) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }
        System.out.println(Randy);
    }
}