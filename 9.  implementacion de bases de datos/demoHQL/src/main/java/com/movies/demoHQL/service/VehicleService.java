package com.movies.demoHQL.service;

import com.movies.demoHQL.model.DTO.PatenteDTO;
import com.movies.demoHQL.model.DTO.PatenteYMarcaDTO;
import com.movies.demoHQL.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService{

    @Autowired
    IVehiculoRepository repository;

    ModelMapper modelMapper = new ModelMapper();

    public List<PatenteDTO> allPatentes(){
        Set<String> patentes = repository.obtenerTodasLasPatentes();
        List<PatenteDTO> patenteDTOS = new ArrayList<>();
        for (String patente : patentes) patenteDTOS.add(new PatenteDTO(patente));
        return patenteDTOS;
    }

    public List<PatenteYMarcaDTO> allPapentesYMarca(){
        Set<Object[]> patentesYMarca = repository.obtenerPatenteYMarca();
        List<PatenteYMarcaDTO> patenteYMarcaDTOS = new ArrayList<>();
        System.out.println(patentesYMarca);
        return null;
    }

}
