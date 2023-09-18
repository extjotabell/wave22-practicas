package org.example;

public class Main {
    public static void main(String[] args) {
        String ciudades[] = new String[10];
        int temperaturas [][] = new int[10][2];

        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asuncion";
        ciudades[5] = "Sao Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Lima";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        temperaturas [0][0] = -2;
        temperaturas [1][0] = -3;
        temperaturas [2][0] = -8;
        temperaturas [3][0] = 4;
        temperaturas [4][0] = 6;
        temperaturas [5][0] = 5;
        temperaturas [6][0] = 0;
        temperaturas [7][0] = -7;
        temperaturas [8][0] = -1;
        temperaturas [9][0] = -10;

        temperaturas [0][1] = 33;
        temperaturas [1][1] = 32;
        temperaturas [2][1] = 27;
        temperaturas [3][1] = 37;
        temperaturas [4][1] = 42;
        temperaturas [5][1] = 43;
        temperaturas [6][1] = 39;
        temperaturas [7][1] = 26;
        temperaturas [8][1] = 31;
        temperaturas [9][1] = 35;

        int maxTemp = getMaxTemp(temperaturas);
        int minTemp = getMinTemp(temperaturas);

        System.out.println("La menor temperatura la tuvo "+ ciudades[minTemp]
                + " con " + temperaturas[minTemp][0]+ " grados");
        System.out.println("La mayor temperatura la tuvo "+ ciudades[maxTemp]
                + " con " + temperaturas[maxTemp][1]+ " grados");
    }

    static int getMaxTemp(int temperaturas[][]){
        int max = 0;
        for (int i = 1; i < 10; i++) {
            if(temperaturas[i][1] > temperaturas[max][1]) {
                max = i;
            }
        }
        return max;
    }

    static int getMinTemp(int temperaturas[][]){
        int min = 0;
        for (int i = 1; i < 10; i++) {
            if(temperaturas[i][0] < temperaturas[min][0]) {
                min = i;
            }
        }
        return min;
    }

}