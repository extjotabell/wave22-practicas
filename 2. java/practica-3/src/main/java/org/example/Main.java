package org.example;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("Agustin Tarda", 25, "41567832");
        Person person3 = new Person("Gonzalo Garcia", 30, "39876908", 78.0, 1.83);
        Person person4 = new Person("Magui Cagna", 15, "41987654", 60, 1.77);
        // Person person4 = new Person("Magui Cagna", 25);
        // al usar un constructor no existente nos devuelve: java: no suitable constructor found for Person(java.lang.String,int)

        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person4);
    }
}