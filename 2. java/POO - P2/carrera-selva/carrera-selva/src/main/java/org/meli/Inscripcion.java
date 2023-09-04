package org.meli;

public class Inscripcion {
    private Integer id;
    private Categoria categoria;
    private Participante participante;
    private Double monto;

    public Inscripcion(Integer id, Categoria categoria, Participante participante) {
        this.id = id;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = calcularMontoInscripcion(participante.getEdad(), categoria.getNombre());
    }

    public Double calcularMontoInscripcion(Integer edadParticipante, String categoria){
        switch(categoria) {
            case "Circuito chico":
               return edadParticipante < 18 ? 1300.0 : 1500.0;
            case "Circuito medio":
                return edadParticipante < 18 ? 2000.0 : 2300.0;
            case "Circuito avanzado":
                return edadParticipante >= 18 ? 2800.0 : 0;
        }
        return 0.0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
