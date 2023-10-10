package com.example.ropa.service;

import com.example.ropa.dto.ClothDTO;
import com.example.ropa.entity.Cloth;
import com.example.ropa.repository.IClothRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClothServiceImpl implements IClothService{

    @Autowired
    IClothRepository repository;

    @Override
    public ClothDTO addCloth(ClothDTO clothDTO) {
        ObjectMapper mapper = new ObjectMapper();
        Cloth cloth = mapper.convertValue(clothDTO,Cloth.class);
        repository.save(cloth);
        return clothDTO;
    }

    @Override
    public List<ClothDTO> getAllClothes() {
        ObjectMapper mapper = new ObjectMapper();
        List<Cloth> clothes = repository.findAll();
        return clothes.stream().map(cloth -> mapper.convertValue(cloth,ClothDTO.class)).toList();
    }

    @Override
    public ClothDTO getByCode(Integer code) {
        ObjectMapper mapper = new ObjectMapper();
        return repository.findById(code)
                .map(c -> mapper.convertValue(c, ClothDTO.class))
                .orElseThrow();
    }

    @Override
    public void updateCloth(Integer code, ClothDTO newCloth) {
        Cloth cloth = repository.findById(code).orElseThrow();
        cloth.setName(newCloth.getName());
        cloth.setType(newCloth.getType());
        cloth.setBrand(newCloth.getBrand());
        cloth.setColor(newCloth.getColor());
        cloth.setSize(newCloth.getSize());
        cloth.setAmount(newCloth.getAmount());
        cloth.setPrecioVenta(newCloth.getPrecioVenta());
        repository.save(cloth);
    }

    @Override
    public void deleteCloth(Integer code) {
        repository.findById(code)
                .ifPresent(c -> repository.delete(c));
    }

    @Override
    public List<ClothDTO> getClothesBySize(Integer size) {
        ObjectMapper mapper = new ObjectMapper();
        List<Cloth> cloths = repository.findBySize(size);
        return cloths.stream().map(c -> mapper.convertValue(c, ClothDTO.class)).toList();
    }

    @Override
    public List<ClothDTO> getClothesByName(String name) {
        ModelMapper mapper = new ModelMapper();
        List<Cloth> cloths = repository.findByNameContainsIgnoreCase(name);
        return cloths.stream().map(c -> mapper.map(c,ClothDTO.class)).toList();
    }


}
