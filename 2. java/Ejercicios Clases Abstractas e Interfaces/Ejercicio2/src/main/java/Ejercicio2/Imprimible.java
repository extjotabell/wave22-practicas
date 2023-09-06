package Ejercicio2;

public interface Imprimible {
    static void imprimirDocumento(Documento doc){
        System.out.println("Imprimiendo -> " + doc.toString());
    }
}
