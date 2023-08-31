public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona(){

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

        if(this.altura == 0)
            return 3;

        double resultado = this.peso / Math.pow(this.altura, 2);
        if (resultado < 20) {
            return -1;
        } else if (resultado >= 20 && resultado <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    private String imcToString(){
        switch (calcularIMC()){
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

    public boolean esMayorEdad(){
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
                ", IMC: "+ imcToString()+
                ", es Adulto: "+ esMayorEdad()+
                '}';
    }
}
