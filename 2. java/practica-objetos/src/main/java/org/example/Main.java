package org.example;

public class Main {
    public static void main(String[] args) {

        Persona personaCompleto= new Persona("Pablo", 22, "12345678",56.8,165.2);
        Persona personaVacio = new Persona();
        Persona personaIntermedio = new Persona("Juan", 42 , "65748493");

        int IMC = personaCompleto.calcularImc();

        if(IMC==-1){
            System.out.println("Bajo de peso");
        }

        else {
            if (IMC == 0) {
                System.out.println("Peso saludable");
            } else {
                System.out.println("Sobrepeso");
            }
        }

        boolean mayorMenor = personaCompleto.esMayorEdad();

        if (mayorMenor){
            System.out.println("Es mayor de edad");
        }

        else{
            System.out.println("Es menor de edad");
        }

        System.out.println(personaCompleto.toString());





    }
}