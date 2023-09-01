public class Vaca extends Animal implements Herbivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Muu");
    }

    public void comer() {
        this.comerHierba();
    }

}
