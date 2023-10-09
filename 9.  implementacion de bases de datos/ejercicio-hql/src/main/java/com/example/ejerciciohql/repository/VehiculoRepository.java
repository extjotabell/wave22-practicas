package com.example.ejerciciohql.repository;

import com.example.ejerciciohql.entity.Vehiculo;
import com.example.ejerciciohql.view.VehiculoFindAllPatentesView;
import com.example.ejerciciohql.view.VehiculoFindAllPatentesAndMarcasView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query(value="SELECT v FROM Vehiculo v")
    List<VehiculoFindAllPatentesView> findAllPatentes();

    @Query("SELECT v FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<VehiculoFindAllPatentesAndMarcasView> findAllPatentesAndMarcasOrderByAnio();
}
