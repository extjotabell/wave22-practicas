public class Main {
    public static void main(String[] args) {
        Prototipo<Integer> serieNumerica2 = new SerieNumerica(2);
        serieNumerica2.valorSiguiente();
        serieNumerica2.valorSiguiente();
        serieNumerica2.valorSiguiente();
        serieNumerica2.valorSiguiente();
        System.out.println("----------------");
        serieNumerica2.reiniciarSerie();
        serieNumerica2.establecerValorInicial(1);
        serieNumerica2.valorSiguiente();
        serieNumerica2.valorSiguiente();
        serieNumerica2.valorSiguiente();
        serieNumerica2.valorSiguiente();
        serieNumerica2.valorSiguiente();
        System.out.println("--------------------");
        Prototipo<Double> serieNumerica3 = new SerieNumerica(3);
        serieNumerica3.valorSiguiente();
        serieNumerica3.valorSiguiente();
        serieNumerica3.valorSiguiente();
        serieNumerica3.valorSiguiente();





    }
}
