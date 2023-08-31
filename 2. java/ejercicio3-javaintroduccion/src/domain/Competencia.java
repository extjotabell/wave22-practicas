package domain;

import java.util.ArrayList;
import java.util.List;

public class Competencia {
    private List<Inscripcion> inscripciones = new ArrayList<>();
    private int montoTotalCarrera;
    private int montoTotalCategoria;

    public Competencia() {
    }

    public void getInscripciones() {
        for (Inscripcion inscripcion : inscripciones) {
            System.out.println(inscripcion);
        }
    }

    public void getInscripcionesCategoria(Categoria categoria) {
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCategoria() == categoria) {
                System.out.println(inscripcion);
            }
        }
    }

    public void removeInscripcion(int id) {
        Categoria categoria = new Categoria();
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getId() == id) {
                categoria = inscripcion.getCategoria();
                inscripciones.remove(inscripcion);
                break;
            }
        }
        getInscripcionesCategoria(categoria);
    }

    public void inscribirCompetencia(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    public int getMontoTotalCarrera() {
        montoTotalCarrera = 0;
        for (Inscripcion inscripcion : inscripciones) {
            montoTotalCarrera += inscripcion.getAbonoParticipante();
        }
        return montoTotalCarrera;
    }

    public int getMontoTotalCategoria(TipoCategoria tipoCategoria) {
        montoTotalCategoria = 0;
        for (Inscripcion inscripcion : inscripciones) {
            if(inscripcion.getCategoria().getTipoCategoria() == tipoCategoria) {
                montoTotalCategoria += inscripcion.getAbonoParticipante();
            }
        }
        return montoTotalCategoria;
    }
}
