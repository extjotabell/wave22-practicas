package documentos;

public class Curriculum implements Imprimible<Curriculum>{
    private String nombre, profesion, estudio;

    public Curriculum(String nombre, String profesion, String estudio) {
        this.nombre = nombre;
        this.profesion = profesion;
        this.estudio = estudio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", profesion='" + profesion + '\'' +
                ", estudio='" + estudio + '\'' +
                '}';
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }
}
