package main;

public class Persona {

    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double imc = peso / ((int)altura ^ 2);
        int res;
        if (imc < 20)
            res = -1;
        else if (imc >= 20 && imc <= 25)
            res = 0;
        else
            res = 1;
        return res;
    }

    public boolean esMayorDeEdad() {
        if (edad < 18)
            return false;
        else
            return true;
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
