package EjercicioJava;

public class Main {
    public static void main(String[] args){
        int[][] matrizTemperatura = new int[10][2];
        String[] ciudades = new String[10];

        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asuncion";
        ciudades[5] = "Sao Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        matrizTemperatura[0][0] = -2;
        matrizTemperatura[0][1] = 33;

        matrizTemperatura[1][0] = -3;
        matrizTemperatura[1][1] = 32;

        matrizTemperatura[2][0] = -8;
        matrizTemperatura[2][1] = 27;

        matrizTemperatura[3][0] = 4;
        matrizTemperatura[3][1] = 37;

        matrizTemperatura[4][0] = 6;
        matrizTemperatura[4][1] = 42;

        matrizTemperatura[5][0] = 5;
        matrizTemperatura[5][1] = 43;

        matrizTemperatura[6][0] = 0;
        matrizTemperatura[6][1] = 39;

        matrizTemperatura[7][0] = -7;
        matrizTemperatura[7][1] = 26;

        matrizTemperatura[8][0] = -1;
        matrizTemperatura[8][1] = 31;

        matrizTemperatura[9][0] = -10;
        matrizTemperatura[9][1] = 35;

        int tempMinima = Integer.MAX_VALUE;
        int tempMaxima = Integer.MIN_VALUE;
        int posicionMinima = 0;
        int posicionMaxima = 0;

        for (int i = 0; i < ciudades.length; i++){
            for (int j = 0; j < 2; j++){

                if(matrizTemperatura[i][j] < tempMinima){
                    tempMinima = matrizTemperatura[i][j];
                    posicionMinima = i;
                }

                if(matrizTemperatura[i][j] > tempMaxima){
                    tempMaxima = matrizTemperatura[i][j];
                    posicionMaxima = i;
                }
            }
        }

        System.out.println(" La temperatura minima fue de " + tempMinima + " y se dio en la ciudad de " + ciudades[posicionMinima]);
        System.out.println(" La temperatura maxima fue de " + tempMaxima + " y se dio en la ciudad de " + ciudades[posicionMaxima]);

    }
}
