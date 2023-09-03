package org.example;

import org.example.Clases.Animal;
import org.example.Clases.Gato;
import org.example.Clases.Perro;
import org.example.Clases.Vaca;
import org.example.Interfaces.Comer;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Perro milo = new Perro("Milo");
        Gato artur = new Gato("Artur");
        Vaca lola = new Vaca("Maxi Romero");

        List<Animal> granja = new ArrayList<>();

        granja.add(milo);
        granja.add(artur);
        granja.add(lola);

        System.out.println("-------------------------------");
        for (Animal animal : granja) {
            animal.emitirSonido();
        }
        System.out.println("\nSomos una granja de animales");

        System.out.println("\n------------------------------");
        System.out.println("Hora de comer");
        comerAnimal(milo);
        comerAnimal(artur);
        comerAnimal(lola);

    }

    public static void comerAnimal(Comer animal){
        animal.comer();
    }
}