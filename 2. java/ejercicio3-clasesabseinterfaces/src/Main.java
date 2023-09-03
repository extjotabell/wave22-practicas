import domain.Gato;
import domain.Perro;
import domain.Vaca;

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        System.out.println(gato.emitirSonido());
        gato.comer();

        System.out.println(perro.emitirSonido());
        perro.comer();

        System.out.println(vaca.emitirSonido());
        vaca.comer();
    }
}
