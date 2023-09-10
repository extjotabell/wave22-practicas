package org.example;

public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;
    private String numCelular;

    public Cliente(String nombre, String apellido, String dni, String numCelular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.numCelular = numCelular;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }
}
