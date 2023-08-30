package org.example;

public class Inscripcion {
    private int numero;
    private Categoria categoria;
    private Participante participante;
    private int monto;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public int calcularMonto(){
        if (categoria.getId()==1 && participante.getEdad()<18) this.monto=1300;
        else if (categoria.getId()==1 && participante.getEdad()>=18) this.monto=1500;
        else if (categoria.getId()==2 && participante.getEdad()<18) this.monto=2000;
        else if (categoria.getId()==2 && participante.getEdad()>=18) this.monto=2300;
        else if (categoria.getId()==3 && participante.getEdad()>=18) this.monto=2800;
        return this.monto;
    }

    public Inscripcion(int numero, Categoria categoria, Participante participante) {
        this.numero = numero;
        this.categoria = categoria;
        this.participante = participante;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numero=" + numero +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", monto=" + this.calcularMonto() +
                '}';
    }
}
