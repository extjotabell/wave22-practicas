package org.example;
public class Persona {
    String nombre;
    int edad;
    String dni;
    float peso;
    float altura;

    public Persona(){

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, float peso, float altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        float IMC = (float) (this.peso/Math.pow(this.altura, 2));
        System.out.println(IMC);
        if(IMC < 20){
            return -1;
        }
        else if(IMC >= 20 && IMC <= 25){
            return 0;
        }
        else{
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        if(this.edad >= 18){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\n" + "Edad: " + edad + "\n" +
                "DNI: " + this.dni + "\n" + "Peso: " + this.peso + "\n" +
                "Altura: " + this.altura;
    }
}
