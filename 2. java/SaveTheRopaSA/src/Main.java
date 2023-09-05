import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

            Prenda prenda = new Prenda("Adidas", "TresBandas");
            Prenda prenda1 = new Prenda("Nike", "AirJordan");

            List<Prenda> prendas = new ArrayList<>();

            prendas.add(prenda);
            prendas.add(prenda1);

            GuardarRopa guardarRopa = new GuardarRopa();
            guardarRopa.guardarPrendas(prendas);
            guardarRopa.mostrarPrendas();
            System.out.println("-------------------------");
            guardarRopa.devolverPrendas(0);
            guardarRopa.mostrarPrendas();
            System.out.println("-------------------------");
            GuardarRopa guardarRopa1 = new GuardarRopa();
            guardarRopa1.guardarPrendas(prendas);
            guardarRopa1.mostrarPrendas();

    }
}