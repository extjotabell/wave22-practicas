package com.example.calorias.dto;

public class PlatoRespuestaDTO extends PlatoDTO {
    private Integer calorias;
    private IngredienteDTO maxCaloriasIngrediente;

    public PlatoRespuestaDTO(PlatoDTO plato) {
        this.setIngredientes(plato.getIngredientes());
        this.setNombre(plato.getNombre());
    }

    public PlatoRespuestaDTO(){}

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    public IngredienteDTO getMaxCaloriasIngrediente() {
        return maxCaloriasIngrediente;
    }

    public void setMaxCaloriasIngrediente(IngredienteDTO maxCaloriasIngrediente) {
        this.maxCaloriasIngrediente = maxCaloriasIngrediente;
    }
}
