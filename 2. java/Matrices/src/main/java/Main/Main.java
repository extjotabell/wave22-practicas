package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String ciudades[] = new String [10];
        double temperaturas[][] = new double [10][2];

        Scanner intro_ciudades = new Scanner(System.in);
        Scanner intro_temperaturas = new Scanner(System.in);

        for (int f = 0; f<= 9; f++){
            System.out.println("Ingrese en nombre de la ciudad para la posicion: " + f);
            ciudades[f] = intro_ciudades.next();

            for (int c = 0; c<=1 ; c++){
                if(c == 0){
                    System.out.println("Ingrese la temperatura minina para: " + ciudades[f]);
                    temperaturas[f][c] = intro_temperaturas.nextInt();
                }
                else{
                    System.out.println("Ingrese la temperatura maxima para: " + ciudades[f]);
                    temperaturas[f][c] = intro_temperaturas.nextInt();
                }
            }
        }

        double tempMinima = temperaturas[0][0];
        String ciudad_minima = ciudades[0];
        double tempMaxima = temperaturas[0][0];
        String ciudad_maxima = ciudades[0];

        for (int f = 0; f<= 9; f++){
            for (int c = 0; c<=1; c++){
                if(temperaturas[f][c] < tempMinima){
                    tempMinima = temperaturas[f][c];
                    ciudad_minima = ciudades[f];
                }
                if(temperaturas[f][c] > tempMaxima){
                    tempMaxima = temperaturas[f][c];
                    ciudad_maxima = ciudades[f];
                }
            }
        }

        System.out.println("La ciudad con minima temperatura es: " + ciudad_minima + " " + tempMinima);
        System.out.println("La ciuad con maxima temperatura es: " + ciudad_maxima + " " + tempMaxima);





    }
}
