package main;
public class Main {
    public static void main(String[] args) {
        String ciudades[] = new String[10];
        int temperaturas[][] = new int[10][2];

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

        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;
        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;
        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;
        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;
        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;
        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;
        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;
        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;
        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;
        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;

        int data[] = getMinMax(temperaturas);
        System.out.println("La temperatura mínima fue " + data[1] + " en " + ciudades[data[0]]);
        System.out.println("La temperatura máxima fue " + data[3] + " en " + ciudades[data[2]]);

    }

    static int[] getMinMax(int temp[][]){
        int data[] = new int[4];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                if(temp[i][j] < data[1]){
                    data[1] = temp[i][j];
                    data[0] = i;
                }
                if(temp[i][j] > data[3]){
                    data[3] = temp[i][j];
                    data[2] = i;
                }
            }
        }

        //El array contiene
        //0- Index temperatura mínima
        //1- Temperatura mínima
        //2- Index temperatura máxima
        //3- Temperatura máxima
        return data;
    }
}