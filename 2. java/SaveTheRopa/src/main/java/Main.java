import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda mochila = new Mochila("ABC", "DEF");
        Prenda campera = new Campera("GHJ","KML");
        List<Prenda>  prendas = new ArrayList<>();
        prendas.add(mochila);
        prendas.add(campera);

        GuardaRopa guardaRopa = new GuardaRopa();
        guardaRopa.guardarPrenda(prendas);
        guardaRopa.mostrarPrenda();
    }
}
