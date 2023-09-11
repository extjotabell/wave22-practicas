package com.clinica.covid19.classes;

public class Sintoma {
    String codigo;
    String nombre;
    int gravedad;

    public Sintoma(String codigo, String nombre, int gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.gravedad = gravedad;
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

    public int getGravedad() {
        return gravedad;
    }

    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }
}
