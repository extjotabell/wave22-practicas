import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardarRopa guardaRopa = new GuardarRopa();

        Prenda prenda1 = new Prenda("Adidas", "Camiseta");
        Prenda prenda2 = new Prenda("Puma", "Campera");

        List<Prenda> prendasGuardadas = new ArrayList<>();
        prendasGuardadas.add(prenda1);
        prendasGuardadas.add(prenda2);

        Integer codigo = guardaRopa.guardarPrendas(prendasGuardadas);
        List<Prenda> prendasCodigo = guardaRopa.devolverPrendas(codigo);


        System.out.println("Prendas guardadas con el código " + codigo + ":");
        for (Prenda prenda : prendasCodigo) {
            System.out.println("Marca: " + prenda.getMarca() + ", Modelo: " + prenda.getModelo());
        }

        Prenda prenda3 = new Prenda("Puma", "Zapatos");
        Prenda prenda4 = new Prenda("Levis", "Jeans");

        List<Prenda> prendasGuardadas2 = new ArrayList<>();
        prendasGuardadas2.add(prenda3);
        prendasGuardadas2.add(prenda4);

        Integer codigo2 = guardaRopa.guardarPrendas(prendasGuardadas2);
        List<Prenda> prendasCodigo2 = guardaRopa.devolverPrendas(codigo2);
        System.out.println("Prendas guardadas con el código " + codigo2 + ":");
        for (Prenda prenda : prendasCodigo2) {
            System.out.println("Marca: " + prenda.getMarca() + ", Modelo: " + prenda.getModelo());
        }

    }
}