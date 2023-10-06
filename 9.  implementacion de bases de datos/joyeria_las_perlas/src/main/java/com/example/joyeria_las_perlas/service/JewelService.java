package com.example.joyeria_las_perlas.service;

import com.example.joyeria_las_perlas.dto.JewelDTO;
import com.example.joyeria_las_perlas.entity.Jewel;
import com.example.joyeria_las_perlas.repository.JewelRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelService implements IJewelService{

    private final JewelRepository jewelRepository;
    private ObjectMapper objectMapper = new ObjectMapper();
    public JewelService(JewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
    }

    @Override
    public Long createJewel(JewelDTO jewelDTO) {
//        System.out.println("JEWELDTO: " + jewelDTO);
        ObjectMapper mapper = new ObjectMapper();
        Jewel jewel = mapper.convertValue(jewelDTO, Jewel.class);
//        System.out.println("JEWEL: " + jewel);
        return this.jewelRepository.save(jewel).getNroIdentificatorio();
    }

    @Override
    public List<JewelDTO> getAll() {
        List<Jewel> jewels = this.jewelRepository.findAll();
        return jewels.stream().map(jewel -> objectMapper.convertValue(jewel, JewelDTO.class)).toList();
    }

    @Override
    public Long deleteJewel(Long id) {
        Jewel jewel = jewelRepository.findById(id).orElse(null);
        if (jewel != null)
        {
            jewel.setVentaONo(false);
            jewelRepository.save(jewel);
            return jewel.getNroIdentificatorio();
        }
        return -1L;
    }

    @Override
    public JewelDTO updateJewel(Long id, JewelDTO updatedJewel) {
        Jewel jewel = jewelRepository.findById(id).orElse(null);
        if (jewel != null)
        {
            Jewel jewelToUpdate = objectMapper.convertValue(updatedJewel, Jewel.class);
            jewelToUpdate.setNroIdentificatorio(id);
            jewelRepository.save(jewelToUpdate);
            return updatedJewel;
        }
        return null;
    }
}
