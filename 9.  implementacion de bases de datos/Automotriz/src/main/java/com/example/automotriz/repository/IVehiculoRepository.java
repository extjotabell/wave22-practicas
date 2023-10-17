package com.example.automotriz.repository;

import com.example.automotriz.model.Vehiculo;
import com.example.automotriz.model.VehiculoData;
import com.example.automotriz.model.VehiculoSiniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    // Listar las patentes de todos los vehículos registrados.
    @Query("SELECT v.patente from Vehiculo v ")
    List<String> getAllPatentes();
    // Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("SELECT v.patente, v.marca FROM Vehiculo v order by v.anioDeFabricacion")
    List<VehiculoData> getPatenteYMarca();
    // Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadDeRuedas > 4 and year(v.anioDeFabricacion) = year(CURRENT_DATE)")
    List<String> getPatenteWithConditions();
    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("SELECT DISTINCT v.patente, v.marca, v.modelo FROM Vehiculo v JOIN Siniestro s ON v = s.vehiculoDenunciante WHERE s.perdidaEconomica > 10000")
    List<VehiculoData> getDetailsForVehiculoWithSiniestroMayorA10000();
    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @Query("SELECT DISTINCT v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica) as perdida_economica_total FROM Vehiculo v JOIN Siniestro s ON v = s.vehiculoDenunciante WHERE s.perdidaEconomica > 10000 GROUP BY v.patente, v.marca, v.modelo")
    List<VehiculoSiniestro> getTotalForVehiculoWithSiniestroMayorA10000();
}
