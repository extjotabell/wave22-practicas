package org.example;

public class Inscripcion {
    private String id;
    private Participante participante;
    private Categoria categoria;

    private Integer monto;

    public Inscripcion(Participante participante, Categoria categoria) {
        this.id= participante.getDni();
        this.participante = participante;
        this.categoria = categoria;
        if(participante.getEdad() < 18){
            if(categoria.getId() == 3){
                System.out.println("No puede inscribirse en esta categoria porque es menor de edad");
                return;
            }
            this.monto = categoria.getMontos().get("Menor");
        }else{
            this.monto = categoria.getMontos().get("Mayor");
        }
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Inscripcion:" +
                "n° de inscripción= " + id +
                ", participante= " + participante +
                ", categoria= " + categoria.getNombre() +
                ", monto= " + monto;
    }
}
