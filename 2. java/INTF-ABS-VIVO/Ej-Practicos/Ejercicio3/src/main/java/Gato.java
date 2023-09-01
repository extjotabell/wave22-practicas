public class Gato extends Animal implements Carnivoro {


    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    public void comer() {
        this.comerCarne();
    }

}
