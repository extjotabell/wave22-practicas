package com.example.demoDTO.dto;

public class PersonaDto {
    private String nombre;
    private String apellido;
    private int edad;
    private DeporteDto deporteDto;

    public PersonaDto(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporteDto = null;
    }

    public void setDeporteDto(DeporteDto deporteDto) {
        this.deporteDto = deporteDto;
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

    public DeporteDto getDeporteDto() {
        return deporteDto;
    }
}
