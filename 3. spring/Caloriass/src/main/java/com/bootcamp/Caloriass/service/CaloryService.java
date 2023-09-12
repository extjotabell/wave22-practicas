package com.bootcamp.Caloriass.service;

import com.bootcamp.Caloriass.dto.InformeCaloricoDTO;

public interface CaloryService {
    InformeCaloricoDTO obtenerInformeCalorico(String plato, Integer gramaje);
}
