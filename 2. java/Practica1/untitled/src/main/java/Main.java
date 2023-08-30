public class Main {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima","Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {
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

        int indice_temp_minima = obtenerIndice(temperaturas, false);
        System.out.println("Ciudad con la mínima temperatura: " + ciudades[indice_temp_minima] + " con: " + temperaturas[indice_temp_minima][0] + "°C.");

        int indice_temp_maxima = obtenerIndice(temperaturas, true);
        System.out.println("Ciudad con la máxima temperatura: " + ciudades[indice_temp_maxima] + " con: " + temperaturas[indice_temp_maxima][1] + "°C.");

    }
    public static int obtenerIndice(int [][] matriz, boolean esMaximo){
        int tempInicial = matriz[0][0];
        int indice = 0;
        for(int i = 0; i< matriz.length; i++){
            if(esMaximo ? matriz[i][0] > tempInicial : matriz[i][0] < tempInicial){
                tempInicial = matriz[i][0];
                indice = i;
            }
        }
        return indice;
    }

}
