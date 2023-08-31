package com.renzobayarri;

public class Main {
    public static void main(String[] args) {

        Persona nicolas = new Persona();

        Persona lucas = new Persona("Lucas", 23, "12345678");

        Persona emanuel = new Persona("Emanuel", 22, "98765432", 70f, 1.7f);

        // No hay constructor
        // Persona renzo = new Persona("Renzo", 31);

        System.out.println(emanuel);
        int imc = emanuel.calcularIMC();
        if(imc == -1){
            System.out.println("Bajo peso");
        }else if(imc == 0){
            System.out.println("Peso saludable");
        }else{
            System.out.println("Sobrepeso");
        }

        if(emanuel.esMayorEdad()){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");
        }
    }
}