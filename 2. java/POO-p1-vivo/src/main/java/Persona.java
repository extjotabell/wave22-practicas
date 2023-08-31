import java.lang.Math;

public class Persona {
    String nombre;
    int edad;
    String dni;
    int peso;
    double altura;

    public Persona() {

    }

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, int peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        float imc;
        double alturaCuad = Math.pow(this.altura, 2);
        imc = (float) (this.peso/alturaCuad);
        System.out.println("imc: " + imc);

        if ( imc < 20 ){
            return -1;
        } else if (imc >= 20 && imc <= 25){
            return 0;
        } else if (imc > 25){
            return 1;
        }

        return 0;
    }

    public boolean esMayordeEdad(){
        if (this.edad >= 18){
            return true;
        }
        return false;
    }

    public void informacionPersona(){
        System.out.println("Nombre: " + this.nombre);
        System.out.println("edad: " + this.edad);
        System.out.println("dni: " + this.dni);
        System.out.println("peso: " + this.peso);
        System.out.println("altura: " + this.altura);
    }

}
