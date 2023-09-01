public class Vaca extends Animal implements Herviboro{

    public Vaca(String tipo) {
        super(tipo);
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuuuu");
    }
}
