package org.example;

public class Person {
    private String name;
    private int age;
    private String dni;
    private double weight;
    private double height;

    public Person() {
    }

    public Person(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Person(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person { " +
                "name: '" + name + '\'' +
                ", age: " + age +
                ", dni: '" + dni + '\'' +
                ", weight: " + weight +
                ", height: " + height +
                ", BMI: " + bmiToString() +
                ", is adult: " + isAdult() +
        " }";
    }

    public int calculateBMI(){
        if(this.height == 0)
            return 3;

        double bmi =  this.weight/Math.pow(this.height, 2);
        if(bmi < 20)
            return -1;
        else if(bmi >= 20 && bmi <= 25)
            return 0;
        else
            return 1;
    }

    private String bmiToString(){
        switch (calculateBMI()){
            case -1:
                return "Bajo peso";
            case 0:
                return "Peso saludable";
            case 1:
                return "Sobrepeso";
            default:
                return "No tenemos datos de altura";
        }
    }

    public boolean isAdult(){
        return this.age >= 18;
    }
}
