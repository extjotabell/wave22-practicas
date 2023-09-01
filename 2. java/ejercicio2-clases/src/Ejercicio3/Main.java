package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato("gato");
        Perro perro = new Perro("perro");
        Vaca vaca = new Vaca("vaca");

        vaca.emitirSonido();
        perro.emitirSonido();
        gato.emitirSonido();

        vaca.comerHierba();
        gato.comerCarne(vaca);
    }
}
