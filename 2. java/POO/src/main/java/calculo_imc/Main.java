package calculo_imc;

public class Main {
    public static void main(String[] args) {

        try {
            Persona persona1 = new Persona();
            Persona persona2 = new Persona("Pepe", 24, "32432123");
            Persona persona3 = new Persona("Jorge", 14, "12432555",72.2,1.70);

            int imc = persona3.calcularIMC();
            boolean mayor = persona3.esMayorDeEdad();
            System.out.println(persona3.toString());

            if (imc == -1){
                System.out.println("Bajo peso");
            } else if (imc == 0) {
                System.out.println("Peso saludable");
            } else {
                System.out.println("Sobrepeso");
            }

            if(mayor){
                System.out.println("Es mayor de edad");
            }else {
                System.out.println("Es menor de edad");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}