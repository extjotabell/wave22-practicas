package org.example;

public class Main {

    static String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
            "Sao Paulo", "Lima", "Santiago de Chile", "lisboa", "Tokyo"};
    static int[][] temperaturas = {{-2, 33},
            {-3, 32},
            {-8, 27},
            {4, 37},
            {6, 42},
            {5, 43},
            {0, 39},
            {-7, 26},
            {-1, 31},
            {-10, 35}};

    public static void main(String[] args) {
        int menorTemperatura = 0;
        int mayorTemperatura = 0;
        int indiceMayor = 0;
        int indiceMenor = 0;
        for(int i=0; i < ciudades.length; i++){
            if(mayorTemperatura < temperaturas[i][1]){
                mayorTemperatura = temperaturas[i][1];
                indiceMayor = i;
            }
            if(menorTemperatura > temperaturas[i][0]){
                menorTemperatura = temperaturas[i][0];
                indiceMenor = i;
            }
        }
        System.out.println("La menor temperatura de la ciudad: " + ciudades[indiceMenor] + " fue de : " + menorTemperatura);
        System.out.println("La mayor temperatura de la ciudad: " + ciudades[indiceMayor] + " fue de : " + mayorTemperatura);

    }
}