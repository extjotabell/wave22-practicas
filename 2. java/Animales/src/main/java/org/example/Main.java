package org.example;

public class Main {
    public static void main(String[] args) {
        // Instanciado de animales
        Vaca vaca = new Vaca();
        Perro perro = new Perro();
        Gato gato = new Gato();

        // Testing metodos
            // Sonidos
        vaca.emitirSonido();;
        perro.emitirSonido();
        gato.emitirSonido();

            // Comida
        System.out.println("Testing metodos vaca comiendo:");
        vaca.comerHierba();

        System.out.println("Testing metodos perro comiendo:");
        perro.comerCarne();
        perro.comerHierba();

        System.out.println("Testing gato perro comiendo:");
        gato.comerCarne();
        gato.comerHierba();

            // Testing metodo Comer animal
        System.out.println("Testing metodo ComerAnimal:");
        comerAnimal(vaca);
        comerAnimal(gato);
        comerAnimal(perro);
    }

    private static void comerAnimal(Animal animal){
        System.out.println("Soy un/una: " + animal.getClass().getSimpleName());

        if(Carnivoro.class.isInstance(animal)) {
            ((Carnivoro) animal).comerCarne();
        }
        if(Herviboro.class.isInstance(animal)) {
            ((Herviboro) animal).comerHierba();
        }
    }
}