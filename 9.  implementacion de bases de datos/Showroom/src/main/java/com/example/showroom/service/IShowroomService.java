package com.example.showroom.service;

import com.example.showroom.dto.ClothesDTO;
import com.example.showroom.dto.OutDTO;
import com.example.showroom.entity.Clothes;

import java.util.List;

public interface IShowroomService {

    OutDTO createClothes(ClothesDTO clothesDTO);

    List<ClothesDTO> getClothes();

    ClothesDTO getClothesByCode(String code);

    OutDTO updateClothesByCode(ClothesDTO clothesDTO,String code);

    OutDTO deleteClothesByCode(String code);

    List<ClothesDTO> getClothesBySize(String size);

    List<ClothesDTO> getClothesByName(String name);
}
