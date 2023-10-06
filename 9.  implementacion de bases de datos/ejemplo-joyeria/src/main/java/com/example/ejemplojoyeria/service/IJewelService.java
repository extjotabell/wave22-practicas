package com.example.ejemplojoyeria.service;

import com.example.ejemplojoyeria.dto.request.JewelRequestDTO;
import com.example.ejemplojoyeria.dto.response.JewelResponseDTO;
import com.example.ejemplojoyeria.dto.response.ResponseDTO;

import java.util.List;

public interface IJewelService {

    List<JewelResponseDTO> getJewels();
    ResponseDTO saveJewel(JewelRequestDTO jewel);

    JewelResponseDTO updateJewel(Long id, JewelRequestDTO jewelRequestDTO);
    void deleteJewel(long id)
;}
