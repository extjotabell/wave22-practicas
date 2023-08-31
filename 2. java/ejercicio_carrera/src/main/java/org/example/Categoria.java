package org.example;

import java.util.HashMap;

public class Categoria {
    private Integer id;
    private String nombre;
    private String descripcion;
    private HashMap<String, Integer> montos = new HashMap<>();

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public HashMap<String, Integer> getMontos() {
        return montos;
    }

    public void setMontos(HashMap<String, Integer> montos) {
        this.montos = montos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria(Integer id, String nombre, String descripcion,HashMap<String, Integer> montos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.montos = montos;
    }
}
