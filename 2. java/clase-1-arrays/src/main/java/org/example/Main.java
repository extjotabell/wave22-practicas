package org.example;

public class Main {
    public static void main(String[] args) {

        String[] ciudades = new String[10];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "Sao Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        //String ciu[] = new String[1];
        //ciu[0] = "Londres";

        //System.out.println(ciu[0]);
        //System.out.println(ciudades[9]);

        float temperaturas[][] = new float[2][10];

        temperaturas[0][0] = -2;
        temperaturas[0][1] = -3;
        temperaturas[0][2] = -8;
        temperaturas[0][3] = 4;
        temperaturas[0][4] = 6;
        temperaturas[0][5] = 5;
        temperaturas[0][6] = 0;
        temperaturas[0][7] = -7;
        temperaturas[0][8] = -1;
        temperaturas[0][9] = -10;
        temperaturas[1][0] = 33;
        temperaturas[1][1] = 32;
        temperaturas[1][2] = 27;
        temperaturas[1][3] = 37;
        temperaturas[1][4] = 42;
        temperaturas[1][5] = 43;
        temperaturas[1][6] = 39;
        temperaturas[1][7] = 26;
        temperaturas[1][8] = 31;
        temperaturas[1][9] = 35;

        //System.out.println(temperaturas[0][9]);

        float mayor = 0;
        String menCiu = "";
        float menor = 99999;
        String mayorCiu = "";
        for (int i=0; i < temperaturas[1].length; i++){

            // check menor
            if(temperaturas[0][i] < menor){
                menor = temperaturas[0][i];
                menCiu = ciudades[i];
            }

            // check mayor
            if(temperaturas[1][i] > mayor){
                mayor = temperaturas[1][i];
                mayorCiu = ciudades[i];
            }
        }

        System.out.println("Ciudad con la menor temperatura: "+ menCiu + " " + menor);
        System.out.println("Ciudad con la mayor temperatura: "+ mayorCiu + " " + mayor);



    }
}