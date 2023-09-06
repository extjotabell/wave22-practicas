package org.example.Ejercicio2;

public class Informe implements Imprimible<Informe>{
    private int longitudTexto;
    private int paginas;
    private String autor;
    private String revisor;

    public Informe(int longitudTexto, int paginas, String autor, String revisor) {
        this.longitudTexto = longitudTexto;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public int getLongitudTexto() {
        return longitudTexto;
    }

    public void setLongitudTexto(int longitudTexto) {
        this.longitudTexto = longitudTexto;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "longitudTexto=" + longitudTexto +
                ", paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }

    @Override
    public void imprimir(Informe informe) {
        System.out.println("Imprimiendo el informe: "+informe);
    }
}
