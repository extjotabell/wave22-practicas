package org.example;

public class Main {
    public static void main(String[] args) {

        int min = 100;
        int max = -100;
        int ind_min=0;
        int ind_max=0;
        String name;

        String[] listCities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] matrixTemperatures = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

        for (int i=0; i < matrixTemperatures.length; i++){
            if(min > matrixTemperatures[i][0]) {
                min = matrixTemperatures[i][0];
                ind_min = i;
            }
            if(max < matrixTemperatures[i][1]){
                max = matrixTemperatures[i][1];
                ind_max = i;
            }
        }

        System.out.println("La ciudad con mayor temperatura: "+listCities[ind_max]);
        System.out.println("Con una temperatura de:"+" "+max);
        System.out.println("La ciudad con menor temperatura"+" "+listCities[ind_min]);
        System.out.println("Con una temperatura de:"+" " +min);
    }
}