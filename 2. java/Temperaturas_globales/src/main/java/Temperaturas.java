public class Temperaturas {


    public static void main(String[] args) {

        int[][] temperaturas = new int[10][2];
        String[] ciudades = new String[10];

        int iMinima = 0;
        int iMaxima = 0;

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

        for(int i=1; i< temperaturas.length; i++){
            if(temperaturas[i][0] < temperaturas[iMinima][0]){
                iMinima = i;
            }
            if(temperaturas[i][1] > temperaturas[iMaxima][1]){
                iMaxima = i;
            }
        }

        System.out.println("Mayor temperatura: "+temperaturas[iMaxima][1]+" en "+ciudades[iMaxima]);

        System.out.println("Menor temperatura: "+temperaturas[iMinima][0]+" en "+ciudades[iMinima]);


    }

}
