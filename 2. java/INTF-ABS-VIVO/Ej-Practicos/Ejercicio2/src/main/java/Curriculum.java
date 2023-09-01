import java.util.List;

public class Curriculum extends Documento {

    private Persona individuo;
    private List<String> habilidades;

    public Curriculum(int cantidadDePaginas, Persona individuo, List<String> habilidades) {
        super(cantidadDePaginas);
        this.individuo = individuo;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum{" +
                "individuo=" + individuo +
                ", habilidades=" + habilidades +
                ", cantidadDePaginas=" + super.getCantidadDePaginas() +
                '}');
    }
}
