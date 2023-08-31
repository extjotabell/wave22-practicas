class Participante {
    int numeroParticipante;
    int dni;
    String nombre;
    String apellido;
    int edad;
    String celular;
    String numeroEmergencia;
    String grupoSanguineo;

    Participante(int numeroParticipante, int dni, String nombre, String apellido, int edad,
                 String celular, String numeroEmergencia, String grupoSanguineo) {
        this.numeroParticipante = numeroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }
}