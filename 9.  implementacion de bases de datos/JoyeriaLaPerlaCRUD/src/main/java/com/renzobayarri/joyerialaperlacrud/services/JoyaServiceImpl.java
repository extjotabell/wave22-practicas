package com.renzobayarri.joyerialaperlacrud.services;

import com.renzobayarri.joyerialaperlacrud.dto.JoyaDTO;
import com.renzobayarri.joyerialaperlacrud.entities.Joya;
import com.renzobayarri.joyerialaperlacrud.exceptions.JoyaNotFoundException;
import com.renzobayarri.joyerialaperlacrud.repositories.JoyaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class JoyaServiceImpl implements JoyaService {

    private JoyaRepository joyaRepository;

    private ModelMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<JoyaDTO> findAll() {
        return joyaRepository.findAllByVentaONoTrue().stream().map(this::toDto).toList();
    }


    @Override
    @Transactional
    public JoyaDTO save(JoyaDTO joyaDTO) {
        return toDto(joyaRepository.save(toEntity(joyaDTO)));
    }

    @Override
    @Transactional
    public JoyaDTO update(JoyaDTO joyaDTO, Long id) {
        Joya saved = findById(id);
        saved.setNombre(joyaDTO.getNombre());
        saved.setPeso(joyaDTO.getPeso());
        saved.setMaterial(joyaDTO.getMaterial());
        saved.setPoseePiedra(joyaDTO.getPoseePiedra());
        saved.setParticularidad(joyaDTO.getParticularidad());
        return toDto(saved);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Joya saved = findById(id);
        saved.setVentaONo(false);
    }

    private Joya findById(Long id) {
        return joyaRepository.findById(id).orElseThrow(() -> new JoyaNotFoundException("No existe joya con id " + id));
    }

    private JoyaDTO toDto(Joya joya) {
        return mapper.map(joya, JoyaDTO.class);
    }

    private Joya toEntity(JoyaDTO joyaDTO) {
        return mapper.map(joyaDTO, Joya.class);
    }
}
