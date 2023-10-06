package com.example.ejemplojoyeria.service;

import com.example.ejemplojoyeria.dto.request.JewelRequestDTO;
import com.example.ejemplojoyeria.dto.response.JewelResponseDTO;
import com.example.ejemplojoyeria.dto.response.ResponseDTO;
import com.example.ejemplojoyeria.model.Jewel;
import com.example.ejemplojoyeria.repository.JewelRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JewelService implements IJewelService {

    @Autowired
    private JewelRepository jewelRepository;
    @Autowired
    private ObjectMapper objectMapper;


    @Transactional(readOnly = true)
    @Override
    public List<JewelResponseDTO> getJewels() {
        List<Jewel> jewels = jewelRepository.findAll();
        return jewels.stream().map(j -> objectMapper.convertValue(j, JewelResponseDTO.class)).toList();
    }

    @Transactional
    @Override
    public ResponseDTO saveJewel(JewelRequestDTO jewelDTO) {
        Jewel jewel = objectMapper.convertValue(jewelDTO, Jewel.class);
        return new ResponseDTO(jewelRepository.save(jewel).getId());
    }

    @Transactional
    @Override
    public void deleteJewel(long id) {
        jewelRepository.deleteById(id);
    }


    @Transactional
    @Override
    public JewelResponseDTO updateJewel(Long id, JewelRequestDTO jewelRequestDTO) {
        if(jewelRepository.existsById(id)) {
            Jewel jewelToSave = objectMapper.convertValue(jewelRequestDTO, Jewel.class);
            jewelToSave.setId(id);
            jewelRepository.save(jewelToSave);
            return objectMapper.convertValue(jewelToSave, JewelResponseDTO.class);
        }
        return null;

    }
}
