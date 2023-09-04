import domain.GuardaRopa;
import domain.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> ropaDeportiva = new ArrayList<>();
        Prenda prendaUno = new Prenda("Nike", "Camiseta entrenamiento");
        Prenda prendaDos = new Prenda("Adidas", "Pantalon largo");
        ropaDeportiva.add(prendaUno);
        ropaDeportiva.add(prendaDos);

        GuardaRopa guardaRopa = new GuardaRopa();

        System.out.println("------Guardando prenda y retornando id-------");
        System.out.println(guardaRopa.guardarPrendas(ropaDeportiva));

        System.out.println("--------Mostrando prendas--------");
        guardaRopa.mostrarPrendas();

        System.out.println("------Mostrando prendas bajo un identificador");
        System.out.println(guardaRopa.devolverPrendas(guardaRopa.getId()));
    }
}
