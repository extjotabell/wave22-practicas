// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /* // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Ctrl+D to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Cmd+F8.
            System.out.println("i = " + i);
        }

        int numero = 35;
        double estatura = 1.67;
        String nombre = "Caupolican";
        boolean bandera = true; */

        System.out.println("----------------------------------------------------------------------------");

        String ciudades[] = new String[10]; // declaro e inicializo un array de 6 posiciones

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

        /* for (int i = 0; i < ciudades.length; i++) {
            System.out.println("Estoy en el indice: " + i);
            System.out.println(" tengo guardado un " + ciudades[i]);
        } */

        System.out.println("----------------------------------------------------------------------------");

        double temperaturas[][] = new double[10][2]; // declaro e inicializo una matriz de 10 filas y 2 columnas

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

        double tempMinima = temperaturas[0][0];
        String ciudadMinima = ciudades[0];
        double tempMaxima = temperaturas[0][0];
        String ciudadMaxima = ciudades[0];

        for (int f = 0; f < temperaturas.length; f++) {
            for (int c = 0; c < temperaturas[f].length; c++) {

                if (temperaturas[f][c]<tempMinima){
                    tempMinima = temperaturas[f][c];
                    ciudadMinima = ciudades[f];
                }

                if (temperaturas[f][c]>tempMaxima){
                    tempMaxima = temperaturas[f][c];
                    ciudadMaxima = ciudades[f];
                }

            }

        }

        System.out.println("La ciudad de " + ciudadMinima + " es la ciudad con la temperatura mínima de: " + tempMinima);
        System.out.println("La ciudad de " + ciudadMaxima + " es la ciudad con la temperatura máxima de: " + tempMaxima);

    }
}