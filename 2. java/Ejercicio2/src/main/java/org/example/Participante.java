package org.example;

public class Participante {
    private String nombre;
    private String apellido; 
    private Integer dni;
    private Integer edad;
    private Integer celular;
    private Integer nroEmergencia;
    private String grpSanguineo;
    private Boolean estado;
    private Integer nroInscripcion;

    public Participante(String nombre, String apellido, Integer dni, Integer edad, Integer celular, Integer nroEmergencia, String grpSanguineo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.celular = celular;
        this.nroEmergencia = nroEmergencia;
        this.grpSanguineo = grpSanguineo;
        this.estado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public Integer getNroInscripcion() {
        return nroInscripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public void setNroInscripcion(Integer nroInscripcion) {
        this.nroInscripcion = nroInscripcion;
    }

}

