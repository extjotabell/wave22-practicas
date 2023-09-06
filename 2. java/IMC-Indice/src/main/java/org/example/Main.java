package org.example;

public class Main {
    public static void main(String[] args) {

        Persona personaSinConstructor = new Persona();
        //Persona personaConstructorFallando = new Persona("Harry", 15); -> Ejemplo que falla porque no existe constructor
        Persona personaConstructorMedio = new Persona("Lionel", 36, "10101010");
        Persona personaConstructorTotal = new Persona("John", 23, "12316534", 67.5,1.74);

        Integer imc = personaConstructorTotal.calculateIMC();
        boolean mayor = personaConstructorTotal.esMayorDeEdad();
        System.out.println(personaConstructorTotal.toString());

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
    }
}


