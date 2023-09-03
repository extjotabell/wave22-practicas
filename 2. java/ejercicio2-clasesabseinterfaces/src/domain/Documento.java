package domain;

public interface Documento {
    static <T> void imprimir(T objeto) {
        System.out.println("Se imprime el contenido del documento: " + objeto);
    }
}
