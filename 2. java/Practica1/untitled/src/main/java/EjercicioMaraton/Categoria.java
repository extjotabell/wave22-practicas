package EjercicioMaraton;

import java.util.ArrayList;
import java.util.List;


public class Categoria {
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    private int id;
    private String nombre;
    private String descripcion;
    private List<Participante> participantes = new ArrayList<Participante>();

    public Categoria(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
