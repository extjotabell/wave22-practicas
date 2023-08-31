package org.example;

public class Persona {
    public String nombre;
    public int edad;
    public String dni;
    public double peso;
    public double altura;

    public Persona(){

    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public int calcularImc(double peso, double altura)
    {
        double imc = peso/(altura*altura);
        if(imc < 20) return -1; // bajo peso
        else if (imc >= 20 && imc < 25) return 0; // saludable
        else return 1; // sobrepeso
    }

    public boolean esMayorDeEdad(int edad)
    {
        return edad >= 18;
    }

    public String toString(Persona persona)
    {
        return "Datos de la persona: DNI= " + persona.dni + ", NOMBRE= " + persona.nombre + ", ALTURA= " +
            persona.altura + ", PESO= " + persona.peso + ", EDAD= " + persona.edad;
    }

}
