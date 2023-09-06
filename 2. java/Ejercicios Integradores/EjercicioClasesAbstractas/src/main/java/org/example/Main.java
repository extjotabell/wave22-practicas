package org.example;

public class Main {
    public static void main(String[] args) {
        Serie2 serie2 = new Serie2(2);
        Serie3 serie3 = new Serie3(3);

        System.out.println("Serie 2: " + serie2.getValorActual());
        System.out.println("Serie 3: " + serie3.getValorActual());

        for(int i=0 ; i < 5 ; i++){
            System.out.println("Serie 2: " + serie2.siguienteValor());
            System.out.println("Serie 3: " + serie3.siguienteValor());
        }

        serie2.reiniciarSerie();
        serie3.reiniciarSerie();
        System.out.println("\n---Reinicio de series---\n");

        System.out.println("Serie 2: " + serie2.getValorActual());
        System.out.println("Serie 3: " + serie3.getValorActual());

        for(int i=0 ; i < 5 ; i++){
            System.out.println("Serie 2: " + serie2.siguienteValor());
            System.out.println("Serie 3: " + serie3.siguienteValor());
        }
    }
}