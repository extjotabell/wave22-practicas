public class Perro extends Animal implements Carnivoro{

    public Perro(String tipo) {
        super(tipo);
    }

    @Override
    public void comerCarne(Animal animal) {
        System.out.println(animal.getTipo());
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }
}
