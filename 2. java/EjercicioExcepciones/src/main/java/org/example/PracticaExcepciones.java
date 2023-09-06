package org.example;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public int cociente(){
        try{
            return b/a;
        }
        catch(ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
    }
}
