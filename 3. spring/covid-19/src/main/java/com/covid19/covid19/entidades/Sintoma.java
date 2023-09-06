package com.covid19.covid19.entidades;

public class Sintoma {
    private int codigo;
    private String nombre;
    private int nivel_de_gravedad;

    public Sintoma(int codigo, String nombre, int nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    @Override
    public String toString() {
        return "Sintoma{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", nivel_de_gravedad=" + nivel_de_gravedad +
                '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel_de_gravedad() {
        return nivel_de_gravedad;
    }
}
