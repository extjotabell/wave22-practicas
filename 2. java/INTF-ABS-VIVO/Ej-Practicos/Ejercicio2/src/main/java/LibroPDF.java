public class LibroPDF extends Documento {

    private String nombreAutor;
    private String genero;
    private String titulo;

    public LibroPDF(String nombreAutor, int cantidadDePaginas, String titulo, String genero) {
        super(cantidadDePaginas);
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("LibroPDF{" +
                "nombreAutor='" + nombreAutor + '\'' +
                ", genero='" + genero + '\'' +
                ", titulo='" + titulo + '\'' +
                ", cantidadDePaginas=" + super.getCantidadDePaginas() +
                '}');
    }

}
