package com.spring.deportistas.services.impl;

import com.spring.deportistas.entities.Deporte;
import com.spring.deportistas.entities.Nivel;
import com.spring.deportistas.services.DeporteService;
import com.spring.deportistas.web.dto.DeporteDTO;
import com.spring.deportistas.web.dto.PersonaDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DeporteServiceImpl implements DeporteService {
    private List<Deporte> deportes;

    public DeporteServiceImpl() {
        Deporte deporte1 = new Deporte("futbol", Nivel.FACIL);
        Deporte deporte2 = new Deporte("natacion", Nivel.DIFICIL);
        Deporte deporte3 = new Deporte("ajedrez", Nivel.FACIL);
        Deporte deporte4 = new Deporte("basquet", Nivel.INTEMERDIO);
        Deporte deporte5 = new Deporte("running", Nivel.FACIL);
        this.deportes = Arrays.asList(deporte1, deporte2, deporte3, deporte4, deporte5);
    }

    @Override
    public List<DeporteDTO> findSports() {
        List<DeporteDTO> deportesDto;
        deportesDto = deportes.stream().map(deporte -> {
            String nombre = deporte.getNombre();
            String nivel = String.valueOf(deporte.getNivel());
            return new DeporteDTO(nombre, deporte.getNivel());
        }).collect(Collectors.toList());
        return deportesDto;
    }

    @Override
    public Deporte findSportByName(String name) {
        Deporte deporteEncontrado = null;
        for (Deporte deporte: deportes) {
            if(Objects.equals(deporte.getNombre(), name)) {
                deporteEncontrado = deporte;
                return deporteEncontrado;
            }
        }
        System.out.println("No se ha encontrado el deporte.");
        return deporteEncontrado;
    }
}
