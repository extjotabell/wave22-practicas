package Main;

import java.util.UUID;

public class Inscripcion {

    UUID id;
    Participante participante;
    int monto;


    public Inscripcion(Participante participante, int monto) {
        this.id = UUID.randomUUID();
        this.participante = participante;
        this.monto = monto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}
