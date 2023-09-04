package org.example;

public class Informe {
    private Integer longitud;
    private Integer paginas;
    private String autor;
    private String revisor;

    @Override
    public String toString() {
        return "Informe{" +
                "longitud=" + longitud +
                ", paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }

    public Informe(Integer longitud, Integer paginas, String autor, String revisor) {
        this.longitud = longitud;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
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
}
