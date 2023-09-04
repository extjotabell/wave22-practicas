import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Prenda camisa = new Prenda("Zara", "verano");
        Prenda jeans = new Prenda("Levis", "511");

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(camisa);
        prendas.add(jeans);

        GuardaRopa guardaRopa = new GuardaRopa();
        guardaRopa.guardarPrendas(prendas);

        System.out.println(guardaRopa);

    }
}