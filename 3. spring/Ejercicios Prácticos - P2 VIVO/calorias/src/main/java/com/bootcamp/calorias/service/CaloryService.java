package com.bootcamp.calorias.service;

import com.bootcamp.calorias.dto.InformeCaloricoDTO;

public interface CaloryService {
    InformeCaloricoDTO obtenerInformeCalorico(String plato, int gramaje);
}
