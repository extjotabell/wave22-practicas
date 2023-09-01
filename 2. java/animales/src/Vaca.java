public class Vaca extends Animal implements Herviboro {

    @Override
    public void hacerSonido() {
        System.out.println("Muuuuuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Como yerba");
    }
}
