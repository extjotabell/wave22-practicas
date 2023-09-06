package org.example;

public class Persona {

    private String name;
    private int age;
    private String dni;
    private Double weight;
    private Double height;

    public Persona() {
    }

    public Persona(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Persona(String name, int age, String dni, Double weight, Double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer calculateIMC(){
        double resultIMC;
        Integer response;
        resultIMC = this.weight/(this.height*this.height);

        if(resultIMC < 20){
            response = -1;
        } else if (resultIMC <= 25) {
            response = 0;
        } else {
            response = 1;
        }

        return response;
    }

    public boolean esMayorDeEdad(){
        return this.age >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dni='" + dni + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
