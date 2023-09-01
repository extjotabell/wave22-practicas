public abstract class Impresora {
    public static <T> void imprimir(T documento) {
        System.out.println(documento.toString());
    }
}
