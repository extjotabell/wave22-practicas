package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Pepe", 24, "32432123");
        Persona persona3 = new Persona("Jorge", 14, "12432555",72.2,1.70);

        Integer imc = persona3.calcularIMC();
        boolean mayor = persona3.esMayorDeEdad();
        System.out.println(persona3.toString());

        if (imc == -1){
            System.out.println("Bajo peso");
        } else if (imc == 0) {
            System.out.println("Peso saludable");
        } else {
            System.out.println("Sobrepeso");
        }

        if(mayor){
            System.out.println("Es mayor de edad");
        }else {
            System.out.println("Es menor de edad");
        }
    }
}