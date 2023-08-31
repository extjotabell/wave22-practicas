import java.util.List;
import java.util.Random;

public class Inscripcion {

    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double monto;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        if(permiteInscripcion(categoria, participante)){
            this.numeroInscripcion = numeroInscripcion;
            this.categoria = categoria;
            this.participante = participante;
            this.monto = calcularMonto(categoria, participante);
            participante.agregarInscripcion(this);
            categoria.agregarInscripcion(this);
        }else {
            System.out.println("No se puede realizar la inscripción.");
        }
    }

    public Inscripcion(int numeroInscripcion, Participante participante) {
        Categoria categoriaRandom;
        do {
            Random random = new Random();
            int indiceAleatorio = random.nextInt(Categoria.categorias.size());
            categoriaRandom = Categoria.categorias.get(indiceAleatorio);
        } while(!permiteInscripcion(categoriaRandom, participante));
            this.numeroInscripcion = numeroInscripcion;
            this.categoria = categoriaRandom;
            this.participante = participante;
            this.monto = calcularMonto(categoriaRandom, participante);
            participante.agregarInscripcion(this);
            categoriaRandom.agregarInscripcion(this);
    }

    private double calcularMonto(Categoria categoria, Participante participante) {
        if (participante.getEdad() < 18) {
            return categoria.getMinorPrice();
        } else {
            return categoria.getAdultPrice();
        }
    }

    public boolean permiteInscripcion(Categoria categoria, Participante participante){
        boolean esAdulto = participante.getEdad() >= 18;
        List<Inscripcion> inscripcionesParticipante = participante.getInscripciones();

        for (Inscripcion inscripcion : inscripcionesParticipante) {
            if (inscripcion.getCategoria().equals(categoria)) {
                return false; // El participante ya tiene una inscripción en esta categoría
            }
        }

        if (!categoria.isMinorAllowed() && !esAdulto) {
            System.out.println(participante.getNombre()+" "+ participante.getApellido()+" No puedes inscribirte a la categoría " + categoria.getNombre() + " por ser menor de edad.");
            return false;
        }

        return true;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public double getMonto() {
        return monto;
    }

    public Categoria getCategoria() {
        return categoria;
    }


}
