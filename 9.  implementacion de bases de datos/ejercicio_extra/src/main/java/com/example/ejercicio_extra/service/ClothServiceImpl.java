package com.example.ejercicio_extra.service;

import com.example.ejercicio_extra.dto.ClothDTO;
import com.example.ejercicio_extra.model.Cloth;
import com.example.ejercicio_extra.repository.ClothRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothServiceImpl implements ClothService {

    @Autowired
    ClothRepository clothRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public ClothDTO createNewCloth(ClothDTO clothDTO) {
        Cloth cloth = mapper.convertValue(clothDTO, Cloth.class);
        Cloth newCloth = clothRepository.save(cloth);
        return mapper.convertValue(newCloth, ClothDTO.class);
    }

    @Override
    public List<ClothDTO> getAllClothes() {
        return clothRepository.findAll().stream().map(cloth -> mapper.convertValue(cloth, ClothDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ClothDTO getCloth(String code) {
        return mapper.convertValue(clothRepository.findClothByCode(code), ClothDTO.class);
    }

    @Override
    public ClothDTO updateCloth(String code, ClothDTO clothDTO) {
        Cloth cloth = mapper.convertValue(clothDTO, Cloth.class);
        cloth.setCode(code);
        return mapper.convertValue(clothRepository.save(cloth), ClothDTO.class);
    }

    @Override
    public String deleteCloth(String code) {
        clothRepository.deleteById(code);
        return "Se elimino correctamente la prenda con el código: " + code;
    }

    @Override
    public List<ClothDTO> getClothesBySize(String size) {
        return clothRepository.findAllByTalle(size).stream().map(cloth -> mapper.convertValue(cloth, ClothDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ClothDTO> getClothesByName(String name) {
        return clothRepository.findAllByNombreContainsIgnoreCase(name).stream().map(cloth -> mapper.convertValue(cloth, ClothDTO.class)).collect(Collectors.toList());
    }
}
