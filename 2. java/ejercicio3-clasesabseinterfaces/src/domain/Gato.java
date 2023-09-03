package domain;

public class Gato extends Animal implements IAlimentarCarne{
    @Override
    public String emitirSonido() {
        return super.emitirSonido() + "Miau miau";
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato esta comiendo carne");
    }
}
