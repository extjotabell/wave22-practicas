package com.example.empresaseguros.service;

import com.example.empresaseguros.dto.*;

import java.util.List;

public interface IVehiculoService {

    Integer create(VehiculoDTO vehiculoDTO);

    List<PatenteDTO> getAllLicensePlate();

    List<MarcaYPatenteDTO> obtenerPatenteYMarcaOrdenadoPorAñoDeFabricacion();

    List<PatenteDTO> obtenerPatenteDeVehiculosMasde4Ruedas();

    List<PatenteMarcaYModeloDTO> obtenerVehiculosConSiniestroMayorA10000();

    List<PatenteMarcaYModeloConPerdidaTotalDTO> obtenerVehiculosConSiniestroMayorA10000YTotalPerdidaEconomica();
}
