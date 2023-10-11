package com.mleiva.showroom.service;

import com.mleiva.showroom.entity.dto.ClothesDto;
import com.mleiva.showroom.entity.dto.RespClothesDto;

import java.util.List;

public interface IClothesService {

    List<ClothesDto> buscarTodos();
    RespClothesDto saveClothes(ClothesDto cart);
    ClothesDto findById(Long id);
    Long actualizar(long id, ClothesDto clothesDto);
    RespClothesDto deleteClothes(Long id);
    List<ClothesDto> findAllBySize(String size);
    List<ClothesDto> findAllByNameContaining(String name);

}
