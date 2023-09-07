package com.example.demoDTO.model;

public class Deporte {
    private String nombre;
    private String nivel;

    // Constructor que acepta nombre y nivel
    public Deporte(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Deporte{" +
                "nombre='" + nombre + '\'' +
                ", nivel='" + nivel + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public String getNivel() {
        return nivel;
    }
}