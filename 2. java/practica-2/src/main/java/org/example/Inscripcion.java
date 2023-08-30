package org.example;

import java.util.Objects;

public class Inscripcion {
    private Integer id;
    private Categoria categoria;
    private Persona participante;
    private Double monto;

    @Override
    public String toString() {
        return "Inscripcion{" +
                "id=" + id +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", monto=" + monto +
                '}';
    }

    public Inscripcion(Integer id, Categoria categoria, Persona participante) throws IllegalArgumentException {
        if(participante.getEdad() < 18 && categoria.getNombre()=="Circuito Avanzado"){
            throw new IllegalArgumentException("El circuito Avanzado no esta disponible para menores de Edad");
        }

        this.id = id;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = this.calcularMonto(participante, categoria);
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

    public Persona getParticipante() {
        return participante;
    }

    public void setParticipante(Persona participante) {
        this.participante = participante;
    }

    private double calcularMonto(Persona participante, Categoria categoria){
        return categoria.getMonto(participante.getEdad() >= 18 ? "Mayor" : "Menor");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inscripcion that = (Inscripcion) o;
        return Objects.equals(participante, that.participante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participante);
    }

    public Double getMonto() {
        return monto;
    }
}
