package domain;

import java.util.ArrayList;
import java.util.Objects;

public class Inscripcion {

    private static int idCache = 0;
    private final int id;
    private Categoria categoria;
    private Participante participante;
    private int abonoParticipante;


    public Inscripcion(Participante participante, Categoria categoria) {
            participante.setCategoria(categoria);
            this.id = idCache++;
            this.participante = participante;
            this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public int getAbonoParticipante() {
        setAbonoParticipante(participante);
        return abonoParticipante;
    }

    public void setAbonoParticipante(Participante participante) {

        if (categoria.getTipoCategoria() == TipoCategoria.CIRCUITO_CHICO) {
            if (participante.getEdad() < 18) {
                abonoParticipante = 1300;
            } else {
                abonoParticipante = 1500;
            }
        }

        if (categoria.getTipoCategoria() == TipoCategoria.CIRCUITO_MEDIO) {
            if (participante.getEdad() < 18) {
                abonoParticipante = 2000;
            } else {
                abonoParticipante = 2300;
            }
        }

        if (categoria.getTipoCategoria() == TipoCategoria.CIRCUITO_AVANZADO) {
            if (participante.getEdad() < 18) {
                System.out.println("No se permite inscripciones a menores de 18 años, intente nuevamente con otra categoria");
            } else {
                abonoParticipante = 2800;
            }
        }
    }

    public Participante getParticipante() {
        return participante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void tieneCategoria() {
        if(participante.getCategoria() != null)  {
            System.out.println("Error. El participante ya tiene categoria!");
        }
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "id=" + id +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", abonoParticipante=" + abonoParticipante +
                '}';
    }
}


