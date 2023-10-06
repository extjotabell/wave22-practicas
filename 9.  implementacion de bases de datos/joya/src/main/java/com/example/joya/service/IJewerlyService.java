package com.example.joya.service;

import com.example.joya.dto.JewerlyDto;
import com.example.joya.models.Jewerly;

import java.util.List;

public interface IJewerlyService {

    Long createJewerly(JewerlyDto jewerlyDto);
    List<JewerlyDto> getJewerlyAll();
    JewerlyDto deleteJewerly(Long id);
    JewerlyDto updateJewerly(JewerlyDto jewerlyDto, Long id);

}
