// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        System.out.println(persona1.toString());
        Persona persona2 = new Persona("434fewf", "Nicolas", 32, 76.32, 1.75);
        System.out.println(persona2.toString());
        Persona persona3 = new Persona("324dfdsfad", "Matias", 23);
        //System.out.println(persona3);

        double imcStatus = persona2.calcularIMC();
        boolean esMayor = persona2.esMayorDeEdad();

        System.out.println("Estado del IMC: " + (imcStatus == -1 ? "Bajo peso" : (imcStatus == 0 ? "Peso saludable" : "Sobrepeso")));
        System.out.println("Es mayor de edad: " + esMayor);
    }

}