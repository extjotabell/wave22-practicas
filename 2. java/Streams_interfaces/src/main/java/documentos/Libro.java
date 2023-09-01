package documentos;

public abstract class Libro {
    private int cantPaginas;
    private String autor;

    public Libro(int cantPaginas, String autor) {
        this.cantPaginas = cantPaginas;
        this.autor = autor;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
