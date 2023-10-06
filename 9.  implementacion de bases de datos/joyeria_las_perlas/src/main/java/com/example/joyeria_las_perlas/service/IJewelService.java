package com.example.joyeria_las_perlas.service;

import com.example.joyeria_las_perlas.dto.JewelDTO;

import java.util.List;

public interface IJewelService {
    Long createJewel(JewelDTO jewelDTO);

    List<JewelDTO> getAll();

    Long deleteJewel(Long id);

    JewelDTO updateJewel(Long id, JewelDTO updatedJewel);
}
