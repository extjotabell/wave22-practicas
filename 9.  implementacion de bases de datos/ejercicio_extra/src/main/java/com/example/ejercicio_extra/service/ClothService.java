package com.example.ejercicio_extra.service;

import com.example.ejercicio_extra.dto.ClothDTO;

import java.util.List;


public interface ClothService {
    ClothDTO createNewCloth(ClothDTO clothDTO);

    List<ClothDTO> getAllClothes();

    ClothDTO getCloth(String code);

    ClothDTO updateCloth(String code, ClothDTO clothDTO);

    String deleteCloth(String code);

    List<ClothDTO> getClothesBySize(String size);

    List<ClothDTO> getClothesByName(String name);
}
