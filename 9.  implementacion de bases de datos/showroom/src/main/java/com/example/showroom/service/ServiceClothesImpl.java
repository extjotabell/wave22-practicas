package com.example.showroom.service;

import com.example.showroom.dto.GarmentDTO;
import com.example.showroom.entity.Garment;
import com.example.showroom.repository.IGarmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceClothesImpl implements IServiceClothes {

    @Autowired
    IGarmentRepository repository;
    @Override
    public GarmentDTO postGarment(GarmentDTO garmentDTO) {
        ObjectMapper mapper = new ObjectMapper();
        Garment garment = mapper.convertValue(garmentDTO, Garment.class);
        garment = repository.save(garment);
        garmentDTO.setId(garment.getId());
        return garmentDTO;
    }

    @Override
    public List<GarmentDTO> getGarmentByName(String name) {
        List<Garment> clothes;
        if (name == null) {
            clothes = repository.findAll();
        }else {
            clothes = repository.findAllByNameContaining(name);
        }
        ObjectMapper mapper = new ObjectMapper();
        return clothes.stream().map(garment -> mapper.convertValue(garment, GarmentDTO.class)).toList();
    }

    @Override
    public GarmentDTO getGarmentById(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Garment> garment = repository.findById(id);
        if (garment.isPresent()){
            return mapper.convertValue(garment.get(), GarmentDTO.class);
        }else{
            throw new RuntimeException("No garment has that name");
        }
    }

    @Override
    public List<GarmentDTO> getGarmentBySize(String size) {
        List<Garment> clothes;
        clothes = repository.findAllBySize(size);

        ObjectMapper mapper = new ObjectMapper();
        return clothes.stream().map(garment -> mapper.convertValue(garment, GarmentDTO.class)).toList();
    }

    @Override
    public Long removeGarment(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
        return id;
    }

    @Override
    public GarmentDTO editGarment(Long id, GarmentDTO garmentDTO) {
        if(repository.existsById(id)){
            garmentDTO.setId(id);
            ObjectMapper mapper = new ObjectMapper();
            Garment garment = mapper.convertValue(garmentDTO, Garment.class);
            repository.save(garment);
        }else {
            throw new RuntimeException("Garment not found");
        }
        return garmentDTO;
    }
}
