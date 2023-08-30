package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        String Ciudades[] = new String[10];
        int[][] Temperatura = new int[10][2];

        Ciudades[0] = "Londres";
        Ciudades[1] = "Madrid";
        Ciudades[2] = "Nueva York";
        Ciudades[3] = "Buenos Aires";
        Ciudades[4] = "Asuncion";
        Ciudades[5] = "Sao Pablo";
        Ciudades[6] = "Lima";
        Ciudades[7] = "Santiago";
        Ciudades[8] = "Lisboa";
        Ciudades[9] = "Tokio";

        Temperatura[0][0] = -2;
        Temperatura[0][1] = 33;
        Temperatura[1][0] = -3;
        Temperatura[1][1] = 32;
        Temperatura[2][0] = -8;
        Temperatura[2][1] = 27;
        Temperatura[3][0] = 4;
        Temperatura[3][1] = 37;
        Temperatura[4][0] = 6;
        Temperatura[4][1] = 42;
        Temperatura[5][0] = 5;
        Temperatura[5][1] = 43;
        Temperatura[6][0] = 0;
        Temperatura[6][1] = 39;
        Temperatura[7][0] = -7;
        Temperatura[7][1] = 26;
        Temperatura[8][0] = -1;
        Temperatura[8][1] = 31;
        Temperatura[9][0] = -10;
        Temperatura[9][1] = 35;

        int indice_min = 0;
        int indice_max = 0;

        for (int i = 1; i < Ciudades.length; i++) {
            if (Temperatura[i][0] < Temperatura[indice_min][0]) {
                indice_min = i;
            }
            if (Temperatura[i][1] > Temperatura[indice_max][1]) {
                indice_max = i;
            }
        }

        System.out.println("Ciudad " + Ciudades[indice_min] + " Temperatura: " + Temperatura[indice_min][0]+"°C");
        System.out.println("Ciudad " + Ciudades[indice_max] + " Temperatura: " + Temperatura[indice_max][1]+"°C");
    }
}