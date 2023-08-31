package main;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Cecilia",32,"12345678");
        Persona persona3 = new Persona("Ivan",39,"12345678",90.5,1.90);
        System.out.println(verificacionImc(persona3));
        System.out.println(verificacionEdad(persona3));
        System.out.println(persona3.toString());

    }
    public static String verificacionImc (Persona p){
        int imc = p.calcularIMC();
        if(imc == -1){
            return "Bajo peso";
        }
        else if(imc == 0){
            return "Peso ideal";
        }
        else{
            return "Sobrepeso";
        }
    }

    public static String verificacionEdad(Persona p){
        boolean edad = p.esMayorDeEdad();
        if(edad){
            return "Es mayor de edad";
        }
        else{
            return "Es menor de edad";
        }
    }
}
