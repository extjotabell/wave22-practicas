public class Informe extends Documento {

    private int longitudDelTexto;

    private String autor;

    private String revisor;

    public Informe(int cantidadDePaginas, int longitudDelTexto, String autor, String revisor) {
        super(cantidadDePaginas);
        this.longitudDelTexto = longitudDelTexto;
        this.autor = autor;
        this.revisor = revisor;
    }


    @Override
    public void imprimir() {
        System.out.println("Informe{" +
                "longitud=" + longitudDelTexto +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", cantidadDePaginas=" + super.getCantidadDePaginas() +
                '}');
    }

}
