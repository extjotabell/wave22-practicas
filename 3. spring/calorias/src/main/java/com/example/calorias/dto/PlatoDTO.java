package com.example.calorias.dto;

import java.util.List;

public class PlatoDTO {
    private String nombre;
    private List<IngredienteDTO> ingredientes;

    public PlatoDTO(){
    }

    public PlatoDTO(String nombre, List<IngredienteDTO> ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<IngredienteDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }

}
