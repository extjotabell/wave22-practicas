public class Perro extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    public void comer() {
        this.comerCarne();
    }

}
