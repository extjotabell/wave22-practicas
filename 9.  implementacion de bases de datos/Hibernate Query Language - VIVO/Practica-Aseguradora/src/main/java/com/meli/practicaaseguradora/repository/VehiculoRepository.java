package com.meli.practicaaseguradora.repository;

import com.meli.practicaaseguradora.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("from Vehiculo v ")
    List<Vehiculo> findAll();

    @Query("from Vehiculo v order by v.anioFabricacion ASC ")
    List<Vehiculo> findAllByYear();

    @Query("from Vehiculo where cantRuedas > 4 and anioFabricacion = year(CURRENT_DATE())")
    List<Vehiculo> findAllByCantWheelAndDate();


    @Query("SELECT v FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica >= 10000")
    List<Vehiculo> findAllBySinBigger10k();


}
