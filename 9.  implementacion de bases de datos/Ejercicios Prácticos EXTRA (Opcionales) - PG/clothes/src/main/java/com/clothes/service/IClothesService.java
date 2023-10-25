package com.clothes.service;

import com.clothes.dto.ClotheDto;
import java.util.List;

public interface IClothesService {

    ClotheDto addClothe(ClotheDto dto);
    List<ClotheDto> getAllClothes();
    ClotheDto getClothe(long id);
    ClotheDto updateClothe(long id, ClotheDto dto);
    ClotheDto deleteClothe(long id);
    List<ClotheDto> getAllClothesBySize(String size);
    List<ClotheDto> getAllClothesByName(String name);
}
