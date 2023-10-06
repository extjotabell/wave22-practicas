package com.example.lasperlas.service;

import com.example.lasperlas.dto.JoyaDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JoyaService {

    long createJewel(JoyaDto joya);
    List<JoyaDto> getAll();

    void deleteJewel(long jewelId);

    JoyaDto updateJewel(long jewelId, JoyaDto newJewel);
}
