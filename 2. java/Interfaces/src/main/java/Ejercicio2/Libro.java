package Ejercicio2;

public class Libro implements Imprimible{
    private int paginas;
    private String autor;
    private String titulo;
    private String genero;

    public Libro(int paginas, String autor, String titulo, String genero) {
        this.paginas = paginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimir " + toString());
    }
}
