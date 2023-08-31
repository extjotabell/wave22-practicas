package org.example;

public class Participante {
    private String nombre;
    private String apellido;
    private String telefono;
    private String grupoSanguineo;
    private String dni;
    private Integer edad;
    private Categoria categoria;

    @Override
    public String toString() {
        return "Participante: " +
                "nombre= '" + nombre + '\'' +
                ", apellido= '" + apellido + '\'' +
                ", dni= '" + dni + '\'' +
                ", edad= " + edad ;
    }

    public Participante(String nombre, String apellido, String telefono, String grupoSanguineo, String dni, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.grupoSanguineo = grupoSanguineo;
        this.dni = dni;
        this.edad = edad;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

}
