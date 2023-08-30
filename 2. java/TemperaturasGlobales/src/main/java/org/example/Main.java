package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        String[] cities = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperatures = new int[][]{{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        int lowestTemp = temperatures[0][0];
        String lowestTempCity = "";
        int highestTemp = temperatures[0][1];
        String highestTempCity = "";

        for(int f = 0; f < temperatures.length; ++f) {
            if (temperatures[f][0] < lowestTemp) {
                lowestTemp = temperatures[f][0];
                lowestTempCity = cities[f];
            }

            if (temperatures[f][1] > highestTemp) {
                highestTemp = temperatures[f][1];
                highestTempCity = cities[f];
            }
        }

        System.out.println(String.format("Lowest Temp is %dºC in %s", lowestTemp, lowestTempCity));
        System.out.println(String.format("Highest Temp is %dºC in %s", highestTemp, highestTempCity));
    }
}