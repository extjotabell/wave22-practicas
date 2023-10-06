package com.example.lasperlas.service;

import com.example.lasperlas.Utils.JoyaMapper;
import com.example.lasperlas.dto.JoyaDto;
import com.example.lasperlas.exception.NotFoundException;
import com.example.lasperlas.model.Joya;
import com.example.lasperlas.repository.JoyaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JoyaServiceImpl implements JoyaService {

    private final JoyaRepository joyaRepository;

    @Override
    public long createJewel(JoyaDto joya) {
        Joya toSave = JoyaMapper.toEntity(joya);
        Joya created = joyaRepository.save(toSave);
        return created.getNroIdentificatorio();
    }

    @Override
    public List<JoyaDto> getAll() {
        return joyaRepository.findByVentaONoIsTrue().stream()
                .map(JoyaMapper::toDto)
                .toList();
    }

    @Override
    public void deleteJewel(long jewelId) {
        Joya joya = joyaRepository.findById(jewelId).orElseThrow(NotFoundException::new);
        joya.setVentaONo(false);
        joyaRepository.save(joya);
    }

    @Override
    public JoyaDto updateJewel(long jewelId, JoyaDto newJewel) {
        Joya joya = joyaRepository.findById(jewelId).orElseThrow(NotFoundException::new);
        joya.setNombre(newJewel.getNombre());
        joya.setMaterial(newJewel.getMaterial());
        joya.setPeso(newJewel.getPeso());
        joya.setParticularidad(newJewel.getParticularidad());
        joya.setPoseePriedra(newJewel.getPoseePiedra());
        joya.setVentaONo(newJewel.getVentaONo());
        Joya updated = joyaRepository.save(joya);
        return JoyaMapper.toDto(updated);
    }
}
