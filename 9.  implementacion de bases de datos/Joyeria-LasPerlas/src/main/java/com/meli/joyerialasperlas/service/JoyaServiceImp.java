package com.meli.joyerialasperlas.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.joyerialasperlas.dto.JoyaDTO;
import com.meli.joyerialasperlas.dto.MessageDTO;
import com.meli.joyerialasperlas.exception.NotFoundException;
import com.meli.joyerialasperlas.model.Joya;
import com.meli.joyerialasperlas.repository.JoyaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JoyaServiceImp implements JoyaService{

    private final JoyaRepository joyaRepository;
    public static final ObjectMapper mapper = new ObjectMapper();

    private final String NOT_FOUND_MESSAGE = "No se encontró la joya con el id: ";

    public JoyaServiceImp(JoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    @Transactional
    public MessageDTO save(JoyaDTO joyaDTO) {
        Joya joya = mapper.convertValue(joyaDTO, Joya.class);
        Long id = joyaRepository.save(joya).getId();
        return new MessageDTO("Nro identificatorio: " + id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JoyaDTO> getAll() {

        return joyaRepository.findAll().stream()
                .filter(Joya::getVentaONo)
                .map(joya -> mapper.convertValue(joya,JoyaDTO.class)).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public JoyaDTO getById(Long id) {
        Joya joya = joyaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_MESSAGE + id));

        return mapper.convertValue(joya, JoyaDTO.class);
    }

    @Override
    @Transactional
    public MessageDTO delete(Long id) {
        Joya joya = joyaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_MESSAGE + id));

        joya.setVentaONo(false);
        joyaRepository.save(joya);
        return new MessageDTO("Joya eliminada con éxito.");
    }

    @Override
    public JoyaDTO update(Long id, JoyaDTO joyaDTO) {
        Joya joya = joyaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_MESSAGE + id));

        joya.setNombre(joyaDTO.getNombre());
        joya.setMaterial(joyaDTO.getMaterial());
        joya.setPeso(joyaDTO.getPeso());
        joya.setParticularidad(joyaDTO.getParticularidad());
        joya.setPoseePiedra(joyaDTO.getPoseePiedra());

        joyaRepository.save(joya);
        return mapper.convertValue(joya, JoyaDTO.class);
    }
}
