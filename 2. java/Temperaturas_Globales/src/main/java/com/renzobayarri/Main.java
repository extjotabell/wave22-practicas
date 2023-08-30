package com.renzobayarri;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String[] cities = new String[10];
        cities[0] = "Londres";
        cities[1] = "Madrid";
        cities[2] = "Nueva York";
        cities[3] = "Buenos Aires";
        cities[4] = "Asunción";
        cities[5] = "São Paulo";
        cities[6] = "Lima";
        cities[7] = "Santiago de Chile";
        cities[8] = "Lisboa";
        cities[9] = "Tokio";

        int[][] temperaturesByCity = new int[10][2];

        temperaturesByCity[0][0] = -2;
        temperaturesByCity[0][1] = 33;

        temperaturesByCity[1][0] = -3;
        temperaturesByCity[1][1] = 32;

        temperaturesByCity[2][0] = -8;
        temperaturesByCity[2][1] = 27;

        temperaturesByCity[3][0] = 4;
        temperaturesByCity[3][1] = 37;

        temperaturesByCity[4][0] = 6;
        temperaturesByCity[4][1] = 42;

        temperaturesByCity[5][0] = 5;
        temperaturesByCity[5][1] = 43;

        temperaturesByCity[6][0] = 0;
        temperaturesByCity[6][1] = 39;

        temperaturesByCity[7][0] = -7;
        temperaturesByCity[7][1] = 26;

        temperaturesByCity[8][0] = -1;
        temperaturesByCity[8][1] = 31;

        temperaturesByCity[9][0] = -10;
        temperaturesByCity[9][1] = 35;

        int posMin = 0;
        int posMax = 0;

        int min = 100;
        int max = -100;

        for (int i = 0; i < cities.length; i++) {
            if(temperaturesByCity[i][0] < min){
                min = temperaturesByCity[i][0];
                posMin = i;
            }
            if(temperaturesByCity[i][1] > max){
                max = temperaturesByCity[i][1];
                posMax = i;
            }
        }

        System.out.printf("Mínima: %d° C%n", min);
        System.out.printf("Ciudad: %s%n", cities[posMin]);
        System.out.printf("Máxima: %d° C%n", max);
        System.out.printf("Ciudad: %s%n", cities[posMax]);
    }
}