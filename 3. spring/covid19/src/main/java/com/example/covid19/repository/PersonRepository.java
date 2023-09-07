package com.example.covid19.repository;

import com.example.covid19.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private final List<Person> people;

    public PersonRepository() {
        people = new ArrayList<>();
        people.add(new Person("Alfredo", "Jimenez", 34));
        people.add(new Person("Micaela", "Nuñez", 42));
        people.add(new Person("Ignacio", "Laprida", 62));
        people.add(new Person("Ana", "Di Stafano", 24));
    }

    public List<Person> getPeople() {
        return people;
    }
}
