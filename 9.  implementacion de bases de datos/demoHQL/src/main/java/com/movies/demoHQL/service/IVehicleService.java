package com.movies.demoHQL.service;

import com.movies.demoHQL.model.DTO.PatenteDTO;
import com.movies.demoHQL.model.DTO.PatenteMarcaDTO;
import com.movies.demoHQL.model.DTO.PatenteMarcaModeloDTO;
import com.movies.demoHQL.model.DTO.PatenteMarcaModeloSumatoriaDTO;

import java.util.List;

public interface IVehicleService {

    List<PatenteDTO> allPatentes();

    List<PatenteMarcaDTO> allPatentesYMarca();

    List<PatenteMarcaModeloDTO> vehiculosConSiniestrosMayorA10000();
    List<PatenteMarcaModeloSumatoriaDTO> vehiculosAndSumConSiniestrosMayorA10000();

}
