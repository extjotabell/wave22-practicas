package documentos;

public interface Imprimible<T> {
    default void imprimir(T objeto){

        System.out.println(objeto.toString());
    }
}
