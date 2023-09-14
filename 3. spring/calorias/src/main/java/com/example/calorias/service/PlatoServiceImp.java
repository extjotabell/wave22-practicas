package com.example.calorias.service;

import com.example.calorias.dto.IngredienteDTO;
import com.example.calorias.dto.PlatoDTO;
import com.example.calorias.dto.PlatoRespuestaDTO;
import com.example.calorias.repositories.IngredientRepository;

public class PlatoServiceImp implements PlatoService{

    private final IngredientRepository ingredientRepository;

    public PlatoServiceImp(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public PlatoRespuestaDTO calcularCalorias(PlatoDTO plato) {

        PlatoRespuestaDTO platoRespuestaDTO = new PlatoRespuestaDTO(plato);

        Integer calorias = 0;
        Integer maxCalorias = 0;
        for (IngredienteDTO ingrediente : plato.getIngredientes()){
            calorias+= ingrediente.getCalorias();
            if (ingrediente.getCalorias() > maxCalorias){
                maxCalorias = ingrediente.getCalorias();
                platoRespuestaDTO.setMaxCaloriasIngrediente(ingrediente);
            }
        }

        platoRespuestaDTO.setCalorias(calorias);

        return platoRespuestaDTO;
    }

}
