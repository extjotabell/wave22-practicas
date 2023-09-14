package com.example.covid_19.entity;

public class Sintoma {
    String codigo;
    String nombre;
    Integer nivel_de_gravedad;

    public Sintoma() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivel_de_gravedad() {
        return nivel_de_gravedad;
    }

    public void setNivel_de_gravedad(Integer nivel_de_gravedad) {
        this.nivel_de_gravedad = nivel_de_gravedad;
    }


}
