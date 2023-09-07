package com.example.demoDTO.model;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporte;

    public Persona(String nombre, String apellido, int edad, String nombreDeporte, String nivel) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte = new Deporte(nombreDeporte, nivel);
    }

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public Deporte getDeporte() {
        return deporte;
    }
}
