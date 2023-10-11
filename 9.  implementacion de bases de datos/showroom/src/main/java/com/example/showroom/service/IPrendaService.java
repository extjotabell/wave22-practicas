package com.example.showroom.service;

import com.example.showroom.dto.PrendaDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPrendaService {
    public PrendaDto newPrenda(PrendaDto prendaDto);

    public List<PrendaDto> getAllPrendas();

    public PrendaDto getPrendaById(Integer id);

    public PrendaDto updatePrenda(Integer prendaId, PrendaDto prendaDto);

    public PrendaDto deletePrendaById(Integer id);

    public List<PrendaDto> getPrendasByTalle(String talle);

    public List<PrendaDto> getPrendasContaining(String contains);
}
