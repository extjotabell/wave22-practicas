package org.example.Documentos.Clases;

import java.util.List;

public class Curriculum extends Documento{

    private String nombre;
    private String apellido;
    private List<String> Habilidades;
    public Curriculum(String nombre, String apellido, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        Habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<String> getHabilidades() {
        return Habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        Habilidades = habilidades;
    }
}
