// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // Serie de enteros con valor inicial 2
        SerieNumerica<Integer> serieEnteros = new SerieEnteros(2);
        for (int i = 0; i < 4; i++) {
            System.out.println("Serie de enteros: " + serieEnteros.obtenerSiguiente());
        }

        System.out.println("-----------------------------------------");
        serieEnteros.establecerValorInicial(1);
        for (int i = 0; i < 4; i++) {
            System.out.println("Serie de enteros: " + serieEnteros.obtenerSiguiente());
        }

        System.out.println("-----------------------------------------");
        SerieNumerica<Integer> serieTres = new SerieEnteros(3);
        for (int i = 0; i < 4; i++) {
            System.out.println("Serie de Tres: " + serieTres.obtenerSiguiente());
        }

    }
}