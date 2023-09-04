package org.meli;

public class Participante {
    private Integer id;
    private Integer dni;
    private String nombre;
    private Integer edad;
    private Integer celular;
    private Integer numEmergencia;
    private String grupoSanguineo;

    @Override
    public String toString() {
        return  "id: " + id +
                ", dni: " + dni +
                ", nombre: '" + nombre + '\'' +
                ", edad: " + edad +
                ", celular: " + celular +
                ", numEmergencia: " + numEmergencia +
                ", grupoSanguineo: '" + grupoSanguineo + '\'' +
                '}';
    }

    public Participante(Integer id, Integer dni, String nombre, Integer edad, Integer celular, Integer numEmergencia, String grupoSanguineo) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.celular = celular;
        this.numEmergencia = numEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public Integer getNumEmergencia() {
        return numEmergencia;
    }

    public void setNumEmergencia(Integer numEmergencia) {
        this.numEmergencia = numEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
}
