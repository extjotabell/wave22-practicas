class Inscripcion {
    int numeroInscripcion;
    Categoria categoria;
    Participante participante;
    double monto;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = calcularMonto();
    }

    private double calcularMonto() {
        int edadParticipante = participante.edad;

        if (categoria.nombre.equals("Circuito chico")) {
            return (edadParticipante < 18) ? 1300 : 1500;
        } else if (categoria.nombre.equals("Circuito medio")) {
            return (edadParticipante < 18) ? 2000 : 2300;
        } else if (categoria.nombre.equals("Circuito avanzado")) {
            return 2800;
        } else {
            return 0;
        }
    }
}
