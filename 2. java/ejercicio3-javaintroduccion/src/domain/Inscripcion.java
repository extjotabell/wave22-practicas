package domain;

import java.util.ArrayList;
import java.util.Objects;

public class Inscripcion {

    private static int idCache = 0;
    private final int id;
    private Categoria categoria;
    private Participante participante;
    int montoAbonado;

    private int montoCategoria;


    public Inscripcion() {
        this.id = idCache++;
    }

    public int getMontoCategoria() {
        return montoCategoria;
    }


    public void setMontoCategoria(Participante participante) {
        final String tipoCategoriaUno = "Circuito Chico";
        final String tipoCategoriaDos = "Circuito Medio";
        final String tipoCategoriaTres = "Circuito Avanzado";

        if (Objects.equals(infoCategoria.get(tipoCategoriaUno), "Circuito Chico")) {
            if (participante.getEdad() < 18) {
                montoCategoria = 1300;
            } else {
                montoCategoria = 1500;
            }
        }

        if (Objects.equals(infoCategoria.get(tipoCategoriaUno), "Circuito Medio")) {
            if (participante.getEdad() < 18) {
                montoCategoria = 2000;
            } else {
                montoCategoria = 2300;
            }
        }

        if (Objects.equals(infoCategoria.get(tipoCategoriaUno), "Circuito Avanzado")) {
            if (participante.getEdad() < 18) {
                System.out.println("No se permite inscripciones a menores de 18 años, intente nuevamente con otra categoria");
            } else {
                montoCategoria = 2800;
            }
        }
    }

    public Participante getParticipante() {
        return participante;
    }

    public void addParticipante (Participante participante){
        participante.add(participante);
    }

    public void removeParticipante ( int dni){
        for (Participante participante : participantes) {
            if (participante.getDni() == dni) {
                participantes.remove(participante);
            }
        }
    }

}


