package com.gym.deportistas.models;

import java.util.List;

public class Person {
    String name;
    String lastname;
    int age;
    List<Sport> sports;

    public List<Sport> getSports() {
        return sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

    public Person(String nombre, String apellido, int edad) {
        this.name = nombre;
        this.lastname = apellido;
        this.age = edad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
