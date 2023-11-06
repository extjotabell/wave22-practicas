package com.example.ejerciciopracticogrupal.repository;

import com.example.ejerciciopracticogrupal.model.Vehiculo;
import com.example.ejerciciopracticogrupal.projection.MarcaPatenteModeloView;
import com.example.ejerciciopracticogrupal.projection.MarcaPatenteView;
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

    @Query("FROM Vehiculo v " +
            "ORDER BY v.fechaFabricacion")
    List<MarcaPatenteView> findAllPatentesYMarcas();

    @Query("SELECT v.patente FROM Vehiculo v " +
            "WHERE v.cantidadRuedas >= 4 " +
            "AND YEAR(v.fechaFabricacion) = YEAR(CURRENT_DATE)")
    List<String> findAllPatentes4RuedasAndActualYear();

    @Query("SELECT " +
                "v.marca AS marca, " +
                "v.modelo AS modelo, " +
                "v.patente AS patente, " +
                "s.perdidaEconomica AS perdidaEconomica " +
            "FROM Vehiculo v " +
            "JOIN v.siniestros s " +
            "WHERE s.perdidaEconomica > 10000")
    List<MarcaPatenteModeloView> findAllPatentesYMarcasConPerdidaEconomica();

    @Query("SELECT " +
            "v.patente AS patente, " +
            "v.marca AS marca, " +
            "v.modelo AS modelo, " +
            "SUM(s.perdidaEconomica) as perdidaEconomica " +
            "FROM Vehiculo v " +
            "JOIN v.siniestros s " +
            "WHERE s.perdidaEconomica > 10000 " +
            "GROUP BY v.patente")
    List<MarcaPatenteModeloView>findAllPatentesYMarcasConPerdidaEconomicaYTotal();
}
