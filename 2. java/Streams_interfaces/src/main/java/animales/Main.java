package animales;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vaca vaca = new Vaca();
        Perro perro = new Perro();
        Gato gato = new Gato();

        vaca.comerHierba();
        perro.comerCarne();
        gato.comerCarne();


    }
}
