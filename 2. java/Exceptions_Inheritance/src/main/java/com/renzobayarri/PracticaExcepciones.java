package com.renzobayarri;

public class PracticaExcepciones {

    private int a = 0;

    private int b = 300;

    public int dividir(){
        int cociente = 0;
        try {
            cociente = b/a;
        }catch (ArithmeticException e){
            System.out.println("Se ha producido un error");
        }finally{
            System.out.println("Programa finalizado");
        }
        return cociente;
    }

    public int dividirCorregido(){
        int cociente = 0;
        try {
            cociente = b/a;
        }catch (ArithmeticException e){
            System.out.println("No se puede dividir por cero");
        }finally{
            System.out.println("Programa finalizado");
        }
        return cociente;
    }
}
