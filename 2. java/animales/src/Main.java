// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
      Animal perro = new Perro();
      Animal vaca = new Vaca();
      Animal gato = new Gato();

      perro.hacerSonido();
      vaca.hacerSonido();
      gato.hacerSonido();

      comerAnimal(perro);
      comerAnimal(vaca);
      comerAnimal(gato);
    }
    public static void comerAnimal(Animal animal) {
        if (animal instanceof Carnivoro) {
            ((Carnivoro) animal).comerCarne();
        } else if (animal instanceof Herviboro) {
            ((Herviboro) animal).comerHierba();
        }
    }
}