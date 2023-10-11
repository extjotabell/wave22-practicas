package com.mleiva.showroom.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespClothesDto {
    private ClothesDto clothesDto;
    private String mensaje;
}
