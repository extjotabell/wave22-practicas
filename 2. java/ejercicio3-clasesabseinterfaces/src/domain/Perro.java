package domain;

public class Perro extends Animal implements IAlimentarCarne{
    @Override
    public String emitirSonido() {
        return super.emitirSonido() + "Guau guau";
    }

    @Override
    public void comer() {
        comerCarne();
    }


    @Override
    public void comerCarne() {
        System.out.println("El perro esta comiendo carne.");
    }
}
