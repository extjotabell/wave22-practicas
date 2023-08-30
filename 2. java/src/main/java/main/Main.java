package main;

public class Main {

    public static void main(String[] args){
        int minima = 100;
        int maxima = -100;
        int ind_min=0;
        int ind_max=0;

        String name;

        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int matrizTemp[][] = {
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


        for (int i=0; i < matrizTemp.length; i++){
            if(minima > matrizTemp[i][0]) {
                minima = matrizTemp[i][0];
                ind_min = i;
            }
            if(maxima < matrizTemp[i][1]){
                maxima = matrizTemp[i][1];
                ind_max = i;
            }
        }

        System.out.println("La ciudad con mayor temperatura: "+ciudades[ind_max]);
        System.out.println("Con una temperatura de:"+" "+maxima);
        System.out.println("La ciudad con menor temperatura"+" "+ciudades[ind_min]);
        System.out.println("Con una temperatura de:"+" " +minima);
    }

}
