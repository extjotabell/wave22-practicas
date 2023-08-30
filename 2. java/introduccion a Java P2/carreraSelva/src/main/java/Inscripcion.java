public class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;

    private int montoAbonar;

    public int getMontoAbonar() {
        return montoAbonar;
    }

    public void setMontoAbonar(int montoAbonar) {
        this.montoAbonar = montoAbonar;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numeroInscripcion=" + numeroInscripcion +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", montoAbonar=" + montoAbonar +
                '}';
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        int posibleMontoAbonar = obtenerMontoAbonar(categoria, participante.getEdad());
        if (posibleMontoAbonar == -1){
            throw new RuntimeException("No se pueden inscribir menores a esta categoria");
        }
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.montoAbonar =  posibleMontoAbonar;
    }

    private static int obtenerMontoAbonar(Categoria categoria, int edad){
        return categoria.obtenerPrecioPorEdad(edad);
    }

}
