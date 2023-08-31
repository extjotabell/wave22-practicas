package org.example;

public class Persona {

    private String nombre;
    private Integer edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {
    }

    public Persona(String nombre, Integer edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, Integer edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Integer calcularIMC(){
        double resultadoIMC;
        Integer respuesta;
        resultadoIMC = this.peso/(this.altura*this.altura);

        if(resultadoIMC < 20){
            respuesta = -1;
        } else if (resultadoIMC <= 25) {
            respuesta = 0;
        } else {
            respuesta = 1;
        }

        return respuesta;
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}