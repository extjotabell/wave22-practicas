package org.example;
public class Tarea1 {
    public Tarea1() {
    }

    public static void main(String[] args) {
        String[] ciudades = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = new int[][]{{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        int indice_temp_minima = buscar_indice_minima(temperaturas);
        System.out.println("Ciudad con la m\u00ednima temperatura: " + ciudades[indice_temp_minima] + " con: " + temperaturas[indice_temp_minima][0] + "\u00b0C.");
        int indice_temp_maxima = buscar_indice_maxima(temperaturas);
        System.out.println("Ciudad con la m\u00e1xima temperatura: " + ciudades[indice_temp_maxima] + " con: " + temperaturas[indice_temp_maxima][1] + "\u00b0C.");
    }

    public static int buscar_indice_minima(int[][] matriz) {
        int temp_minima = 100;
        int indice = 0;

        for(int i = 0; i <= 9; ++i) {
            if (matriz[i][0] < temp_minima) {
                temp_minima = matriz[i][0];
                indice = i;
            }
        }

        return indice;
    }

    public static int buscar_indice_maxima(int[][] matriz) {
        int temp_maxima = -100;
        int indice = 0;

        for(int i = 0; i <= 9; ++i) {
            if (matriz[i][1] > temp_maxima) {
                temp_maxima = matriz[i][1];
                indice = i;
            }
        }

        return indice;
    }
}
