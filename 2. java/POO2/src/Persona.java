public class Persona {
    String dni;
    String nombre;
    int edad;
    double peso;
    double altura;

    Persona() {}

    Persona(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    Persona(String dni, String nombre, int edad, double peso, double altura) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC() {
        double alturaEnMetros = altura / 100;
        double imc = peso / (Math.pow(alturaEnMetros, 2));

        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public String toString() {
        return "Nombre: " + nombre +
                "\nEdad: " + edad +
                "\nDNI: " + dni +
                "\nPeso: " + peso +
                "\nAltura: " + altura;
    }

}

