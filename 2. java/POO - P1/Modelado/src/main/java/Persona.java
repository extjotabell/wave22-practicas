public class Persona {
    private String nombre;
    private String dni;
    private int edad;
    private double peso;
    private double altura;

    public Persona() {}
    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }
    public Persona(String nombre, String dni, int edad, double peso, double altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC() {
        double resultadoIMC = peso/Math.pow(altura, 2);
        if (resultadoIMC >= 20 && resultadoIMC <= 25 ) {
            return 0;
        }
        if (resultadoIMC < 20) {
            return -1;
        }
        return 1;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Nombre='" + nombre + '\'' +
                ", Dni='" + dni + '\'' +
                ", Edad=" + edad +
                ", Peso=" + peso +
                ", Altura=" + altura;
    }
}
