public class Main {
    public static void main(String[] args) {

        // 3 constructores
        Persona p1 = new Persona();
        Persona p2 = new Persona("Zadie Smith", 26, "18024245-2");
        Persona p3 = new Persona("Mario Hugo", 31, "17852489-1", 75, 1.75);

        // Prueba solo nombre y edad. No debería ser posible
        // Persona p4 = new Persona("Juan Carlos", 31); // No es posible

        p3.informacionPersona();

        boolean esMayor = p3.esMayordeEdad();
        if (esMayor){
            System.out.println("Es mayor de edad");
        }

        int catgImc = p3.calcularIMC();

        if (catgImc == -1) {
            System.out.println("Bajo peso");
        } else if (catgImc == 0) {
            System.out.println("Peso saludable");
        } else if (catgImc == 1) {
            System.out.println("Sobrepeso");
        }

    }
}