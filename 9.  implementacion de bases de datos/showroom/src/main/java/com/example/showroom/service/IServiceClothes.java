package com.example.showroom.service;

import com.example.showroom.dto.GarmentDTO;

import java.util.List;

public interface IServiceClothes {
    GarmentDTO postGarment(GarmentDTO garmentDTO);
    List<GarmentDTO> getGarmentByName(String name);
    GarmentDTO getGarmentById(Long id);
    List<GarmentDTO> getGarmentBySize(String size);
    Long removeGarment(Long id);
    GarmentDTO editGarment(Long id, GarmentDTO garmentDTO);
}
