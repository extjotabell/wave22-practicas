package com.example.lasperlas.service;

import com.example.lasperlas.dto.JoyaDTO;

import java.util.List;

public interface ILasPerlasService {
    List<JoyaDTO> getAllJoyas();
    Long saveJoya(JoyaDTO joyaToSave);
    String deleteJoya(Long joyaIdToDelete);
    JoyaDTO findJoyaById(Long joyaIdToFind) throws Exception;
    JoyaDTO updateJoyaById(Long joyaIdToUpdate, JoyaDTO joyaNewInfo) throws Exception;
}
