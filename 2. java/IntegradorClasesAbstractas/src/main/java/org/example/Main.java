package org.example;

public class Main {
    public static void main(String[] args) {
        SerieProgresiva serieProgresiva = new SerieProgresiva(5);
        serieProgresiva.iniciarSerie(2);
        System.out.println(serieProgresiva.siguiente());
        System.out.println(serieProgresiva.siguiente());
        System.out.println(serieProgresiva.siguiente());
    }
}