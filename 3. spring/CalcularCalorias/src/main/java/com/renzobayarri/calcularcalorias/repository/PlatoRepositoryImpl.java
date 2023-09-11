package com.renzobayarri.calcularcalorias.repository;

import com.renzobayarri.calcularcalorias.model.Ingrediente;
import com.renzobayarri.calcularcalorias.model.Plato;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PlatoRepositoryImpl implements PlatoRepository {

    private List<Plato> platos;

    private IngredienteRepository ingredienteRepository;

    public PlatoRepositoryImpl() {
        platos = new ArrayList<>();
        List<Ingrediente> ingredientesFideos = new ArrayList<>();
        ingredientesFideos.add(ingredienteRepository.findIngredienteByName("Manteca"));
        ingredientesFideos.add(ingredienteRepository.findIngredienteByName("Pasta al huevo"));
        ingredientesFideos.add(ingredienteRepository.findIngredienteByName("Aceite de girasol"));
        platos.add(new Plato("Fideos", ingredientesFideos));

        List<Ingrediente> ingredientesMilanesa = new ArrayList<>();
        ingredientesMilanesa.add(ingredienteRepository.findIngredienteByName("Pollo"));
        ingredientesMilanesa.add(ingredienteRepository.findIngredienteByName("Papas cocidas"));
        platos.add(new Plato("Milanesa", ingredientesMilanesa));
    }

    public Plato findPlatoByName(String name) {
        return platos.stream().filter(p -> p.getNombre().equals(name)).findFirst().get();
    }
}
