package com.renzobayarri.calcularcalorias.service;

import com.renzobayarri.calcularcalorias.dto.IngredienteDTO;
import com.renzobayarri.calcularcalorias.dto.PlatoDTO;
import com.renzobayarri.calcularcalorias.model.Ingrediente;
import com.renzobayarri.calcularcalorias.model.Plato;
import com.renzobayarri.calcularcalorias.repository.PlatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
@AllArgsConstructor
public class PlatoServiceImpl implements PlatoService {

    private PlatoRepository platoRepository;

    public PlatoDTO getInfoPlatoByName(String nombrePlato, double peso) {
        Plato plato = platoRepository.findPlatoByName(nombrePlato);

        double multiplicador = peso / 100;

        PlatoDTO platoDTO = new PlatoDTO();
        platoDTO.setNombre(plato.getNombre());
        platoDTO.setIngredientes(plato.getIngredientes().stream().map(this::toIngredienteDTO).toList());
        platoDTO.setCalorias(plato.getIngredientes().stream().mapToInt(Ingrediente::getCalories).sum() * multiplicador);
        platoDTO.setIngredienteMayorCalorias(plato.getIngredientes().stream()
                .sorted(Comparator.comparingInt(Ingrediente::getCalories)
                        .reversed())
                .findFirst()
                .get()
                .getName());
        return platoDTO;
    }

    public IngredienteDTO toIngredienteDTO(Ingrediente ingrediente) {
        return new IngredienteDTO(ingrediente.getName(), ingrediente.getCalories());
    }
}
