public class Vaca extends Animal implements Herviboro{
    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public String comerHierba() {
        return "Muuuuu ricooo";
    }
}