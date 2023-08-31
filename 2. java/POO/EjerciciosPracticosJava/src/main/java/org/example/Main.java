package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       Persona persona1 = new Persona("Lucas", 23, "12345678");
       Persona persona2 = new Persona("Santiago", 16, "12345678", 70, 1.80);

       System.out.println(persona1);
       double imcPersona1 = persona1.imc();
       if(imcPersona1== -1){
           System.out.println("Bajo peso");
       } else if(imcPersona1== 0){
           System.out.println("Peso Saludable");
       } else{
           System.out.println("Sobrepeso");
       }

       if(persona1.mayorEdad()){
           System.out.println("Es mayor de edad");
       } else {
           System.out.println("Es menor de edad");
       }

    }
}