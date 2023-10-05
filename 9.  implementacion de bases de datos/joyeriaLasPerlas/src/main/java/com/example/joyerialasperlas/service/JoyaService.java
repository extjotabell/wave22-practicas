package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.JoyaDto;
import com.example.joyerialasperlas.model.Joya;
import com.example.joyerialasperlas.repository.IJoyaRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoyaService implements IJoyaService {

    @Autowired
    IJoyaRepository repository;

    ModelMapper mapper = new ModelMapper();

    //TODO: faltan validaciones generales para casos NotFound, BadRequest, entre otros, y respuestas de TipoDto

    @Override
    public List<JoyaDto> getAllJewelry() {
        List<Joya> joyas = repository.findAll();
        List<JoyaDto> joyaDtos = new ArrayList<>();
        for (Joya joya : joyas) {
            if (joya.getVentaONo()) joyaDtos.add(mapper.map(joya,JoyaDto.class));
        }
        return joyaDtos;
    }

    @Override
    public JoyaDto getJewelry(Long id) {
        Joya joya = repository.findById(id).orElse(null);
        return mapper.map(joya,JoyaDto.class);
    }

    @Override
    @Transactional
    public Long saveJewerly(JoyaDto joyaDto) {
        Joya joyaToSave = mapper.map(joyaDto,Joya.class);
        repository.save(joyaToSave);
        return joyaToSave.getNro_identificatorio();
    }

    @Override
    public void deleteJewerly(Long id) {
        Joya joya = repository.findById(id).orElse(null);
        joya.setVentaONo(false);
        repository.save(joya);
    }

    @Override
    public Long updateJewerly(Long id, JoyaDto joyaDto) {
        Joya joya = repository.findById(id).orElse(null);
        Joya updatedJoya = mapper.map(joyaDto, Joya.class);
        updatedJoya.setNro_identificatorio(joya.getNro_identificatorio());
        repository.save(updatedJoya);
        return updatedJoya.getNro_identificatorio();
    }


}
