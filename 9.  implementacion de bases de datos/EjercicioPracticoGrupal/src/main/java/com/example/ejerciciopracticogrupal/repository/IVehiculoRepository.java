package com.example.ejerciciopracticogrupal.repository;

import com.example.ejerciciopracticogrupal.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v.patente " +
            "FROM Vehiculo v")
    List<String> findAllPatentes();

    @Query("SELECT v.patente, v.marca " +
            "FROM Vehiculo v " +
            "ORDER BY v.fechaFabricacion")
    List<Vehiculo> findAllPatentesYMarcas();

    @Query("SELECT v.patente FROM Vehiculo v " +
            "WHERE v.cantidadRuedas >= 4 " +
            "AND YEAR(v.fechaFabricacion) = YEAR(CURRENT_DATE)")
    List<String> findAllPatentes4RuedasAndActualYear();

    @Query("SELECT v.patente, v.marca, v.modelo " +
            "FROM Vehiculo v " +
            "JOIN v.siniestros s " +
            "WHERE s.perdidaEconomica > 10000")
    List<Vehiculo> findAllPatentesYMarcasConPerdidaEconomica();

    @Query("SELECT v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica) " +
            "FROM Vehiculo v " +
            "JOIN v.siniestros s " +
            "WHERE s.perdidaEconomica > 10000 " +
            "GROUP BY v.patente")
    List<Pair<Vehiculo, Double>>findAllPatentesYMarcasConPerdidaEconomicaYTotal();
}
