public class Perro extends  Animal implements Carnivoro{
    @Override
    public void hacerSonido() {
        System.out.println("Gua");
    }

    @Override
    public void comerCarne() {
        System.out.println("Como carne");
    }
}
