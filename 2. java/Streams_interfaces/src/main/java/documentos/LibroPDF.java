package documentos;

public class LibroPDF extends Libro implements Imprimible<LibroPDF>{
    private String titulo, genero;

    public LibroPDF(int cantPaginas, String autor, String titulo, String genero) {
        super(cantPaginas, autor);
        this.titulo = titulo;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "cantPaginas=" + super.getCantPaginas() +
                ", nombreAutor='" + super.getAutor() + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
