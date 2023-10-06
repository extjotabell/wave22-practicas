package com.meli.joyas.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.joyas.dto.JoyaDto;
import com.meli.joyas.model.Joya;
import com.meli.joyas.repository.IJoyaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Service
public class JoyaService implements IJoyaService {
    private final IJoyaRepository joyaRepository;
    private ObjectMapper objectMapper;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.objectMapper = new ObjectMapper();
        this.joyaRepository = joyaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Joya> getAllJoyas() {
        return joyaRepository.findByVentaONoTrue();
    }

    @Override
    @Transactional
    public String createJoya(JoyaDto joyaDto) {
        Joya joya = objectMapper.convertValue(joyaDto, Joya.class);
        joya.setVentaONo(true);
        joyaRepository.save(joya);
        return joya.getId().toString();
    }

    @Transactional
    public Joya updateJoya(Long id, JoyaDto updatedJoyadto) {
        Joya existingJoya = this.findById(id);
        if (existingJoya != null) {
            Joya updatedJoya = objectMapper.convertValue(updatedJoyadto, Joya.class);;
            existingJoya.setNombre(updatedJoya.getNombre());
            existingJoya.setMaterial(updatedJoya.getMaterial());
            existingJoya.setPeso(updatedJoya.getPeso());
            existingJoya.setParticularidad(updatedJoya.getParticularidad());
            existingJoya.setPosee_piedra(updatedJoya.isPosee_piedra());

            return joyaRepository.save(existingJoya);
        } else {
            return null;
        }
    }
    @Override
    @Transactional
    public String deleteJoya(Long id) {
        Joya joyaToDelete = this.findById(id);;

        if (joyaToDelete != null) {
            joyaToDelete.setVentaONo(false);
            joyaRepository.save(joyaToDelete);
            return "Joya eliminada correctamente";
        } else {
            return "Joya no pudo eliminarse";
        }
    }
    @Override
    @Transactional(readOnly = true)
    public Joya findById(Long id) {
        return joyaRepository.findById(id).orElse(null);
    }

}
