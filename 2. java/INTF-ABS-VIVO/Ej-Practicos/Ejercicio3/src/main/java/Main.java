public class Main {

    public static void main(String[] args) {

        Animal animal1 = new Gato();
        Animal animal2 = new Vaca();
        Animal animal3 = new Perro();


        comerAnimal(animal1);
        comerAnimal(animal2);
        comerAnimal(animal3);
    }

    public static void comerAnimal(Animal animal) {
        animal.comer();
    }

}
