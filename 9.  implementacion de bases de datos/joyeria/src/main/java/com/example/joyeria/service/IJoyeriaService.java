package com.example.joyeria.service;

import com.example.joyeria.dto.JoyaDTO;
import com.example.joyeria.repository.IJoyeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IJoyeriaService {

    Long create(JoyaDTO joyaDTO);

    List<JoyaDTO> getAll();

}
