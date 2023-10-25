package com.movies.demoHQL.service;

import com.movies.demoHQL.model.DTO.PatenteDTO;
import com.movies.demoHQL.model.DTO.PatenteYMarcaDTO;

import java.util.List;

public interface IVehicleService {

    List<PatenteDTO> allPatentes();

    List<PatenteYMarcaDTO> allPapentesYMarca();

}
