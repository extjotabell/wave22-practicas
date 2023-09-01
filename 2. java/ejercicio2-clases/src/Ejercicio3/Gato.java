package Ejercicio3;

public class Gato extends Animal implements Carnivoro{

    public Gato(String tipo) {
        super(tipo);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miauuuuuu");
    }

    @Override
    public void comerCarne(Animal animal) {
        System.out.println("Comiendo "+ animal.getTipo());
    }
}
