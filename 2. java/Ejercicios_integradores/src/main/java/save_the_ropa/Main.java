package save_the_ropa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Remera remera = new Remera("Nike", "Remera", "Blanca", false);
        Remera remera1 = new Remera("Zara", "Remera", "Negra", true);

        List<Prenda> listaPrendas = new ArrayList<>();

        listaPrendas.add(remera);
        listaPrendas.add(remera1);


        Remera remera2 = new Remera("Zara", "Remera", "Negra", true);
        Remera remera3 = new Remera("Zara", "Remera", "Negra", true);

        List<Prenda> listaPrendas1 = new ArrayList<>();

        listaPrendas1.add(remera2);
        listaPrendas1.add(remera3);

        GuardaRopa guardaRopa = new GuardaRopa();
        guardaRopa.guardarPrendas(listaPrendas);
        guardaRopa.guardarPrendas(listaPrendas1);

        guardaRopa.mostrarPrendas();

        System.out.println(guardaRopa.devolverPrendas(1));
        System.out.println(guardaRopa.devolverPrendas(2));

    }
}
