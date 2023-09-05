package org.example;

public class Main {
    public static void main(String[] args) {
        Serie serieDeDos = new SerieDeDos();
        Serie serieDeTres = new SerieDeTres();

        serieDeDos.establecerValorInicial(2);
        for (int i = 0; i < 5; i++) {
            System.out.println("Serie de 2 - Valor siguiente: " + serieDeDos.siguiente());
        }

        // Reiniciar la serie
        serieDeDos.reiniciar();

        serieDeTres.establecerValorInicial(1);
        for (int i = 0; i < 5; i++) {
            System.out.println("Serie de 3 - Valor siguiente: " + serieDeTres.siguiente());
        }
    }
}