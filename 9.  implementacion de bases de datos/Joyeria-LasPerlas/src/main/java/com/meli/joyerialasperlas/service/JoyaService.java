package com.meli.joyerialasperlas.service;

import com.meli.joyerialasperlas.dto.JoyaDTO;
import com.meli.joyerialasperlas.dto.MessageDTO;
import com.meli.joyerialasperlas.model.Joya;

import java.util.List;

public interface JoyaService {

    MessageDTO save (JoyaDTO joyaDTO);
    List<JoyaDTO> getAll ();
    JoyaDTO getById (Long id);
    MessageDTO delete (Long id);
    JoyaDTO update(Long id, JoyaDTO joyaDTO);

}
