import java.util.Objects;

public class Participante {

    private int numeroParticipante;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int numeroEmergencia;
    private String grupoSanguineo;

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public void setNumeroParticipante(int numeroParticipante) {
        this.numeroParticipante = numeroParticipante;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(int numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    @Override
    public String toString() {
        return "\t\tParticipante: " +
                "\n \t\t\tnumeroParticipante=" + numeroParticipante +
                "\n \t\t\tdni=" + dni +
                "\n \t\t\tnombre='" + nombre + '\'' +
                "\n \t\t\tapellido='" + apellido + '\'' +
                "\n \t\t\tedad=" + edad +
                "\n \t\t\tcelular=" + celular +
                "\n \t\t\tnumeroEmergencia=" + numeroEmergencia +
                "\n \t\t\tgrupoSanguineo='" + grupoSanguineo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return numeroParticipante == that.numeroParticipante && dni == that.dni && edad == that.edad && celular == that.celular && numeroEmergencia == that.numeroEmergencia && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(grupoSanguineo, that.grupoSanguineo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroParticipante, dni, nombre, apellido, edad, celular, numeroEmergencia, grupoSanguineo);
    }

    public Participante(int numeroParticipante, int dni, String nombre, String apellido, int edad, int celular, int numeroEmergencia, String grupoSanguineo) {
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
