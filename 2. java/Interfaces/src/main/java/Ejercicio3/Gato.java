package Ejercicio3;

public class Gato extends Animal implements Alimentacion{
    @Override
    public void sonido() {
        System.out.println("Miauu");
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Como carne");
    }

    @Override
    public void comerHierba() {

    }
}
