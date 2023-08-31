package com.renzobayarri;

public class Main {
    public static void main(String[] args) {
        PracticaExcepciones p = new PracticaExcepciones();
        int cociente = p.dividir();
        System.out.println(cociente);

        int cocienteCorregido = p.dividirCorregido();
        System.out.println(cocienteCorregido);

    }
}