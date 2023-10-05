package com.renzobayarri.joyerialaperlacrud.services;

import com.renzobayarri.joyerialaperlacrud.dto.JoyaDTO;

import java.util.List;

public interface JoyaService {

    List<JoyaDTO> findAll();

    JoyaDTO save(JoyaDTO joyaDTO);

    JoyaDTO update(JoyaDTO joyaDTO, Long id);

    void delete(Long id);
}
