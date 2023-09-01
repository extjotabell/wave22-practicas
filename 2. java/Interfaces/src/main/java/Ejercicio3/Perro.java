package Ejercicio3;

public class Perro extends Animal implements Alimentacion{
    @Override
    public void sonido() {
        System.out.println("Guauu");
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
