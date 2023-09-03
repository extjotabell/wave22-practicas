// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.println("Creo paso a 2");
        SumasNumerica<Integer> serieEnteros = new SumaEnteros(0, 2);

        System.out.println(serieEnteros.obtenerSiguienteValor());
        System.out.println(serieEnteros.obtenerSiguienteValor());
        System.out.println(serieEnteros.obtenerSiguienteValor());
        System.out.println(serieEnteros.obtenerSiguienteValor());

        System.out.println("CAMBIO VALOR INICIAL A 1");
        serieEnteros.establecerValorInicial(1);

        System.out.println(serieEnteros.obtenerSiguienteValor());
        System.out.println(serieEnteros.obtenerSiguienteValor());
        System.out.println(serieEnteros.obtenerSiguienteValor());
        System.out.println(serieEnteros.obtenerSiguienteValor());

        System.out.println("CAMBIO VALOR INICIAL A 3");
        serieEnteros.establecerValorInicial(1);

        System.out.println(serieEnteros.obtenerSiguienteValor());
        System.out.println(serieEnteros.obtenerSiguienteValor());
        System.out.println(serieEnteros.obtenerSiguienteValor());
        System.out.println(serieEnteros.obtenerSiguienteValor());

        System.out.println("CAMBIO PASO A 3.0");
        SumasNumerica<Double> serieDoubles = new SumaDecimales(0.0, 3.0);

        System.out.println(serieDoubles.obtenerSiguienteValor());
        System.out.println(serieDoubles.obtenerSiguienteValor());
        System.out.println(serieDoubles.obtenerSiguienteValor());
        System.out.println(serieDoubles.obtenerSiguienteValor());
    }
}