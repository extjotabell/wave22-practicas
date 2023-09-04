package org.example;

import java.util.List;

public class Curriculum {
   /* incluye a una persona con todos sus atributos más una lista de sus habilidades*/
    private String nombre;
    private String educacion;
    private String experienciaLaboral;
    private String fechaNacimiento;
    private Integer numeroContacto;
    private String email;
    private List<String> habilidades;

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", educacion='" + educacion + '\'' +
                ", experienciaLaboral='" + experienciaLaboral + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", numeroContacto=" + numeroContacto +
                ", email='" + email + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }

    public Curriculum(String nombre, String educacion, String experienciaLaboral, String fechaNacimiento, Integer numeroContacto, String email, List<String> habilidades) {
        this.nombre = nombre;
        this.educacion = educacion;
        this.experienciaLaboral = experienciaLaboral;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroContacto = numeroContacto;
        this.email = email;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEducacion() {
        return educacion;
    }

    public void setEducacion(String educacion) {
        this.educacion = educacion;
    }

    public String getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(String experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(Integer numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
