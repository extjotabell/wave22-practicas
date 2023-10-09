package com.example.joyeria.service;

import com.example.joyeria.dto.JoyaDTO;
import com.example.joyeria.entity.Joya;
import com.example.joyeria.repository.IJoyeriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoyeriaService implements IJoyeriaService {


    private final IJoyeriaRepository repo;

    public JoyeriaService(IJoyeriaRepository repo) {
        this.repo = repo;
    }

    public Long create(JoyaDTO joyaDTO) {
        ObjectMapper mapper = new ObjectMapper();
        Joya joya = mapper.convertValue(joyaDTO, Joya.class);
        return repo.save(joya).getNro_identificatorio();
    }

    @Override
    public List<JoyaDTO> getAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<Joya> joyas = repo.findAllByVentaONoTrue();
        return joyas.stream().map(joya -> mapper.convertValue(joya, JoyaDTO.class)).toList();
    }

    @Override
    public Long delete(Long id) {
        Optional<Joya> joya = repo.findById(id);
        if (joya.isEmpty() || !joya.get().isVentaONo()){
            throw new RuntimeException("Usuario no encontrado");
        }
        joya.get().setVentaONo(false);
        repo.save(joya.get());
        return id;
    }

    @Override
    public JoyaDTO update(JoyaDTO joyaDTO, Long id) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Joya> searchedJoya = repo.findById(id);
        if ( searchedJoya.isEmpty()  || !searchedJoya.get().isVentaONo()){
            throw new RuntimeException("Joya no encontrada");
        }
        Joya joya = mapper.convertValue(joyaDTO, Joya.class);
        joya.setNro_identificatorio(id);
        repo.save(joya);
        return mapper.convertValue(joya, JoyaDTO.class);
    }

}