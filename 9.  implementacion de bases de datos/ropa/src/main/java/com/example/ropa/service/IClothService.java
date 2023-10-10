package com.example.ropa.service;

import com.example.ropa.dto.ClothDTO;

import java.util.List;

public interface IClothService {

    ClothDTO addCloth(ClothDTO clothDTO);
    List<ClothDTO> getAllClothes();
    ClothDTO getByCode(Integer code);
    void updateCloth(Integer code, ClothDTO newCloth);
    void deleteCloth(Integer code);
    List<ClothDTO> getClothesBySize(Integer size);
    List<ClothDTO> getClothesByName(String name);
}
