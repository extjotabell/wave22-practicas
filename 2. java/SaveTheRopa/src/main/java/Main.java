import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaropa = new GuardaRopa();

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(new Prenda("A", "A"));
        prendas.add(new Prenda("B", "B"));

        Integer nro = guardaropa.guardarPrendas(prendas);
        guardaropa.mostrarPrendas();
        guardaropa.devolverPrendas(nro);
    }
}
