package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Calculadora calcu = new Calculadora();

        double resultadoSuma = calcu.suma(3,5);
        System.out.println("Resultado de la suma: " + resultadoSuma );

        CalculadoraCientifica calcuCientifica = new CalculadoraCientifica();
        int resultadoFactorial = calcuCientifica.factorial(6);
        System.out.println("La factorial resulta de 6 es: " + resultadoFactorial );


    }
}