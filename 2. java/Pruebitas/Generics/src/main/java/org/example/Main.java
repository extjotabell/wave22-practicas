package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Printer<Animal> printer = new Printer<>(new Cat());
        printer.print();

        ArrayList<Animal> listOfAnimals = new ArrayList<>();
        listOfAnimals.add(new Cat());
        listOfAnimals.add(new Dog());

        Dog animal = (Dog) listOfAnimals.get(1);
        animal.eat();

        shout("Holaaaa", "Locooo");
        shout(21, "Rules");
        shout(13.21, "Yes");

        List<Integer> intList = new ArrayList<>();
        intList.add(21);
        printList(intList);

    }

    public static <T, V> void shout(T thingToShout, V otherThingToShout){
        System.out.println(thingToShout + "!!!!");
        System.out.println(otherThingToShout + "!!!!");
    }

    public static void printList(List<?> myList){
        System.out.println(myList);
    }
}