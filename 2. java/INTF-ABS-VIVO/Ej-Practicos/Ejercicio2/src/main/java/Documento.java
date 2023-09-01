public abstract class Documento implements Imprimible {

    private int cantidadDePaginas;

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    protected Documento(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public abstract void imprimir();

    @Override
    public void imprimirTipoDoc() {
        System.out.println(getClass().getSimpleName().toUpperCase());
    }

}
