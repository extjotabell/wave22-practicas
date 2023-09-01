package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.sonido();
        perro.comer();
        gato.sonido();
        gato.comer();
        vaca.sonido();
        vaca.comer();
        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);

    }
    public static void comerAnimal (Animal animal){
        animal.comer();
    }
}
