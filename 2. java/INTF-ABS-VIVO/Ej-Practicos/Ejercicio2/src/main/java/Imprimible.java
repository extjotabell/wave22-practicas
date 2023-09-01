public interface Imprimible {

    default void imprimirDocumento(Documento documentoAImprimir) {
        documentoAImprimir.imprimir();
    }
    void imprimirTipoDoc();

}
