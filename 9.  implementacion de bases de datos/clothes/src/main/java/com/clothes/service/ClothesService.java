package com.clothes.service;

import com.clothes.dto.ClotheDto;
import com.clothes.model.Clothes;
import com.clothes.repository.IClothesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothesService implements IClothesService{

    @Autowired
    IClothesRepository repository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public ClotheDto addClothe(ClotheDto dto) {
        Clothes clothe = modelMapper.map(dto, Clothes.class);
        return modelMapper.map(repository.save(clothe), ClotheDto.class);
    }

    @Override
    public List<ClotheDto> getAllClothes() {
        List<Clothes> allClothes = repository.findAll();
        List<ClotheDto> allClothesDto = allClothes.stream().map(clothe -> modelMapper.map(clothe,ClotheDto.class)).collect(Collectors.toList());
        return allClothesDto;
    }

    @Override
    public ClotheDto getClothe(long id) {
        Clothes clothes = repository.findById(id).orElse(null);
        if (clothes == null) {
            throw new RuntimeException("No existe la prenda con id: " + id);
        }
        return modelMapper.map(clothes, ClotheDto.class);
    }

    @Override
    public ClotheDto updateClothe(long id, ClotheDto dto) {
        Clothes clotheToUpdate = repository.findById(id).get();

        clotheToUpdate.setName(dto.getName());
        clotheToUpdate.setType(dto.getType());
        clotheToUpdate.setBrand(dto.getBrand());
        clotheToUpdate.setColor(dto.getColor());
        clotheToUpdate.setSize(dto.getSize());
        clotheToUpdate.setQuantity(dto.getQuantity());
        clotheToUpdate.setPrice(dto.getPrice());

        return modelMapper.map(repository.save(clotheToUpdate), ClotheDto.class);
    }

    @Override
    public ClotheDto deleteClothe(long id) {
        ClotheDto clotheDeleted = modelMapper.map(repository.findById(id).get(), ClotheDto.class);
        repository.deleteById(id);
        return clotheDeleted;
    }

    @Override
    public List<ClotheDto> getAllClothesBySize(String size) {
        return repository.findAllBySize(size)
                .stream().map(clothe -> modelMapper.map(clothe, ClotheDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ClotheDto> getAllClothesByName(String name) {
        return repository.findAllByNameContainingIgnoreCase(name)
                .stream().map(clothe -> modelMapper.map(clothe, ClotheDto.class))
                .collect(Collectors.toList());
    }
}
