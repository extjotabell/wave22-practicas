package com.example.lasperlas.Utils;

import com.example.lasperlas.dto.JoyaDto;
import com.example.lasperlas.model.Joya;

public class JoyaMapper {

    private JoyaMapper(){

    }

    public static Joya toEntity(JoyaDto joyaDto) {
        return Joya.builder()
                .nombre(joyaDto.getNombre())
                .material(joyaDto.getMaterial())
                .peso(joyaDto.getPeso())
                .particularidad(joyaDto.getParticularidad())
                .poseePriedra(joyaDto.getPoseePiedra())
                .ventaONo(joyaDto.getVentaONo())
                .build();
    }

    public static JoyaDto toDto(Joya joya) {
        return JoyaDto.builder()
                .nombre(joya.getNombre())
                .material(joya.getMaterial())
                .peso(joya.getPeso())
                .particularidad(joya.getParticularidad())
                .poseePiedra(joya.getPoseePriedra())
                .ventaONo(joya.getVentaONo())
                .build();
    }
}
