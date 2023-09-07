package org.example;

public class PracticaExcepciones {
    private int a;
    private int b;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public double calculateCociente(){
        double cociente = 0;
        try {
            cociente = b/a;
        } catch(Exception e) {
            System.out.println("Se ha producido un error");
        } finally{
            System.out.println("Programa finalizado");
        }
        return cociente;
    }

    public int calculateCocienteModificado(){
        int cociente = 0;
        try {
            if (cociente == 0) throw new IllegalArgumentException("No se puede dividir por cero");
            cociente = b/a;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Programa finalizado");
        }
        return cociente;
    }

}
