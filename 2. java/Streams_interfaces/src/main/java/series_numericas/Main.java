package series_numericas;

public class Main {
    public static void main(String[] args) {
        Prototipo serie = new Prototipo(1, 2);

        for(int i=0; i<4; i++){
            System.out.println(serie.devolverSiguiente());
        }

        System.out.println("\n");
        serie.reiniciarSerie();
        for(int i=0; i<4; i++){
            System.out.println(serie.devolverSiguiente());
        }

        System.out.println("\n");
        serie.inicializar(0);
        for(int i=0; i<4; i++){
            System.out.println(serie.devolverSiguiente());
        }
    }
}
