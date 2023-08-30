package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String ciudades[] = new String[10];
        int temperaturas[][] = new int[10][2];

        /*ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires ";
        ciudades[4] = "Asunción";
        ciudades[5] = "Sao Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokyo";

        temperaturas[0][0] = -2;
        temperaturas[1][0] = 3;
        temperaturas[2][0] = -8;
        temperaturas[3][0] = 4;
        temperaturas[4][0] = 6;
        temperaturas[5][0] = 5;
        temperaturas[6][0] = 0;
        temperaturas[7][0] = -7;
        temperaturas[8][0] = -1;
        temperaturas[9][0] = -10;

        temperaturas[0][1] = 33;
        temperaturas[1][1] = 22;
        temperaturas[2][1] = 27;
        temperaturas[3][1] = 37;
        temperaturas[4][1] = 42;
        temperaturas[5][1] = 43;
        temperaturas[6][1] = 39;
        temperaturas[7][1] = 26;
        temperaturas[8][1] = 31;
        temperaturas[9][1] = 37;*/

        Scanner ciudad = new Scanner(System.in);
        Scanner temp = new Scanner(System.in);
        for(int i = 0; i < 10; i++) {
            System.out.println("Ingrese el nombre del pais en la posición "+i);
            ciudades[i] = ciudad.nextLine();
            for(int j = 0; j < 2; j++) {
                if(j == 0) {
                    System.out.println("Ingrese la menor temperatura de "+ciudades[i]);
                    temperaturas[i][j] = temp.nextInt();
                }
                if(j == 1) {
                    System.out.println("Ingrese la mayor temperatura de "+ciudades[i]);
                    temperaturas[i][j] = temp.nextInt();
                }
            }
        }

        int indiceMenorTemp = 0;
        int indiceMayorTemp = 0;
        for(int i = 1; i < 10; i++) {
            if(temperaturas[i][0] < temperaturas[indiceMenorTemp][0]) {
                indiceMenorTemp = i;
            }
            if(temperaturas[i][1] > temperaturas[indiceMayorTemp][1]) {
                indiceMayorTemp = i;
            }
        }
        System.out.println("Pais con menor temperatura: "+ciudades[indiceMenorTemp]);
        System.out.println("Temperatura: "+temperaturas[indiceMenorTemp][0]);
        System.out.println("Pais con mayor temperatura: "+ciudades[indiceMayorTemp]);
        System.out.println("Temperatura: "+temperaturas[indiceMayorTemp][1]);

    }
}
