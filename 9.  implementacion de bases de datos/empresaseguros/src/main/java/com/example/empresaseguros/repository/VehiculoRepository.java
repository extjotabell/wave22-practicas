package com.example.empresaseguros.repository;

import com.example.empresaseguros.dto.MarcaYPatenteDTO;
import com.example.empresaseguros.dto.PatenteDTO;
import com.example.empresaseguros.dto.PatenteMarcaYModeloDTO;
import com.example.empresaseguros.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
    @Query("SELECT new com.example.empresaseguros.dto.PatenteDTO(v.patente) FROM Vehiculo v")
    public List<PatenteDTO> obtenerTodasLasPatentes();

    @Query("SELECT new com.example.empresaseguros.dto.MarcaYPatenteDTO(v.patente, v.marca, v.añoFabricacion) FROM Vehiculo v ORDER BY v.añoFabricacion")
    public List<MarcaYPatenteDTO> obtenerPatenteYMarcaOrdenadoPorAñoDeFabricacion();

    @Query("SELECT new com.example.empresaseguros.dto.PatenteDTO(v.patente) FROM Vehiculo v WHERE v.cantidadRuedas >= 4 AND year(v.añoFabricacion) = year(current_date())")
    public List<PatenteDTO> patentesMasDe4RuedasDeEsteAño();

    @Query("SELECT new com.example.empresaseguros.dto.PatenteMarcaYModeloDTO(v.patente, v.marca, v.modelo) FROM Vehiculo v JOIN v.siniestros vs WHERE vs.perdidaEconomica > 10000")
    public List<PatenteMarcaYModeloDTO> obtenerVehiculosConSiniestroMayorA10000();
}
