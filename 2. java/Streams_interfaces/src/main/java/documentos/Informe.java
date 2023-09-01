package documentos;

public class Informe extends Libro implements Imprimible<Informe> {
    private String texto, revisor;

    public Informe(int cantPaginas, String autor, String texto, String revisor) {
        super(cantPaginas, autor);
        this.texto = texto;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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
                "texto='" + texto + '\'' +
                ", autor='" + super.getAutor() + '\'' +
                ", revisor='" + revisor + '\'' +
                ", cantPaginas=" + super.getCantPaginas() +
                '}';
    }
}


