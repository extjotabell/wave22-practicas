package com.example.empresaseguros.service;

import com.example.empresaseguros.dto.SiniestroDTO;
import com.example.empresaseguros.entity.Siniestro;
import com.example.empresaseguros.entity.Vehiculo;
import com.example.empresaseguros.repository.SiniestroRepository;
import com.example.empresaseguros.repository.VehiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SiniestroService implements ISiniestroService {

    @Autowired
    SiniestroRepository repository;

    @Autowired
    VehiculoRepository vehiculoRepository;

    public Integer create(SiniestroDTO siniestroDTO){
        ObjectMapper mapper = new ObjectMapper();
        Siniestro siniestro = mapper.convertValue(siniestroDTO, Siniestro.class);
        try{
            //Vehiculo vehiculo =vehiculoRepository.getReferenceById(siniestro.getId_vehiculo_denunciado());
            //vehiculo.getSiniestros().add(siniestro);
            return repository.save(siniestro).getId_siniestro();
        }catch(Exception e){
            throw e;
        }

    }
}
