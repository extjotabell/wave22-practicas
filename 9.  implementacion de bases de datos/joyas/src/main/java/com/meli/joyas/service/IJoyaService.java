package com.meli.joyas.service;

import com.meli.joyas.dto.JoyaDto;
import com.meli.joyas.model.Joya;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IJoyaService {
    public List<Joya> getAllJoyas();
    public String createJoya(JoyaDto joya);
    public Joya updateJoya(Long id, JoyaDto updatedJoya);
    public String deleteJoya(Long id);
    public Joya findById(Long id);

}
