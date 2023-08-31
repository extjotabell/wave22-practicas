package EjercicioMaraton;

public class Participante {

    private int id;
    private String nombre;
    private int edad;

    private String dni;

    private String apellido;

    private String numeroEmergencia;

    private String grupoSangre;

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public String getGrupoSangre() {
        return grupoSangre;
    }

    public Participante(int id, String nombre, int edad, String dni, String apellido, String numeroEmergencia, String grupoSangre) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.apellido = apellido;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSangre = grupoSangre;
    }
}
