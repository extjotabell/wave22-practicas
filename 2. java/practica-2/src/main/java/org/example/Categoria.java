package org.example;

import java.util.Map;

public class Categoria {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Map<String, Integer> montos;

    public Categoria(Integer id, String nombre, String descripcion, Map<String, Integer> montos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.montos = montos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
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

    public Integer getMonto(String key){
        return this.montos.get(key);
    }
    public void setMontos(Map<String, Integer> montos) {
        this.montos = montos;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", montos=" + montos +
                '}';
    }
}
