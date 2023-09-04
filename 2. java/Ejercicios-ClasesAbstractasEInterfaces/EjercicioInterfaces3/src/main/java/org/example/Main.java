package org.example;

import Interfaces.Comestible;
import models.Animal;
import models.Gato;
import models.Perro;
import models.Vaca;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Animal> animales = List.of(
                new Vaca(true, false),
                new Perro(false, true),
                new Gato(false, true)
        );

        for(int i = 0; i < animales.size(); i++)
        {
            if (animales.get(i).carnivoro)
            {
                animales.get(i).comerCarne();
            }
            else animales.get(i).comerHierba();
        }

        Optional<Animal> animalCarnivoro = animales.stream().filter(animal -> animal.carnivoro).findFirst();
        Optional<Animal> animalHerbivoro = animales.stream().filter(animal -> animal.herbivoro).findFirst();
        animalCarnivoro.ifPresent(
                animalCarn -> {
                    animalHerbivoro.ifPresent(animalHerb ->
                    {
                        animalCarn.comerAnimal(animalHerb);
                    });
                }
        );
    }
}