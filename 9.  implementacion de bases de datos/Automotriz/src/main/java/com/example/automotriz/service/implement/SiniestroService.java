package com.example.automotriz.service.implement;

import com.example.automotriz.dto.SiniestroDTO;
import com.example.automotriz.model.Siniestro;
import com.example.automotriz.repository.ISiniestroRepository;
import com.example.automotriz.service.ISiniestroService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiniestroService implements ISiniestroService {

    private ISiniestroRepository siniestroRepository;

    public SiniestroService(ISiniestroRepository siniestroRepository){
        this.siniestroRepository = siniestroRepository;
    }

    @Override
    public SiniestroDTO buscarPorId(Long id) {
        return toDTO(siniestroRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sinistro con id " + id + " no encontrado")));
    }

    @Override
    public List<SiniestroDTO> buscarTodos() {
        return siniestroRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public String crearSiniestro(SiniestroDTO dto) {
        siniestroRepository.save(toEntity(dto));
        return null;
    }

    private SiniestroDTO toDTO(Siniestro siniestro){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(siniestro, SiniestroDTO.class);
    }

    private Siniestro toEntity(SiniestroDTO siniestroDTO){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(siniestroDTO, Siniestro.class);
    }
}
