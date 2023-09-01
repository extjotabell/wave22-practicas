package Ejercicio3;

public class Vaca extends Animal implements Alimentacion{
    @Override
    public void sonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comer() {
        comerHierba();
    }

    @Override
    public void comerCarne() {

    }

    @Override
    public void comerHierba() {
        System.out.println("Como pasto...");
    }
}
