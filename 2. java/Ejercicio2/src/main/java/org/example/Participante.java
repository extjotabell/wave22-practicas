package org.example;

public class Participante {
    public int numero;
    public int dni;
    public String nombre;
    public String apellido;
    public int edad;
    public int celular;
    public int numeroDeEmergencia;
    public String grupoSanguineo;
    public int numeroDeInscripcion;

    public Participante(int numero, int dni, String nombre, String apellido, int edad, int celular, int numeroDeEmergencia, String grupoSanguineo) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroDeEmergencia = numeroDeEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }
}
