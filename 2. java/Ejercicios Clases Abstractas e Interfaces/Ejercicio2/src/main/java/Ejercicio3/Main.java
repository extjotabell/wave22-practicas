package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        gato.comerCarne();
        gato.emitirSonido();

        perro.emitirSonido();
        perro.comerCarne();

        vaca.emitirSonido();
        vaca.comerHierba();

        Animal.comer(gato);
        Animal.comer(vaca);

    }
}
