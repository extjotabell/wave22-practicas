package domain;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class Categoria {

    private static int idCache = 0;
    private final int id;
    private Map<String, String> infoCategoria;
    private ArrayList<Inscripcion> inscripciones;


    public Categoria() {
        this.id = idCache++;
    }

    public Categoria(String tipoCategoria, String detalleCategoria) {
        this();
        infoCategoria.put(tipoCategoria, detalleCategoria);
    }

    public Map<String, String> getInfoCategoria() {
        return infoCategoria;
    }

    public void removeInscripcion(int dni) {
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getParticipante().getDni() == dni) {
                inscripcion.removeParticipante(inscripcion);
            }
        }
    }




    public int getId() {
        return id;
    }



    Calcular el monto total recaudado por cada categoría

    y el total de toda la carrera incluyendo todas las categorías.

}
