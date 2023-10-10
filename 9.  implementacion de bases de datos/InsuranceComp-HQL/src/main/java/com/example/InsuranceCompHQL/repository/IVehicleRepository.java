package com.example.InsuranceCompHQL.repository;

import com.example.InsuranceCompHQL.entity.PlateBrand;
import com.example.InsuranceCompHQL.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("select v.plate from Vehicle v")
    List<String> getAllPlates();

    @Query("select v.plate, v.brand from Vehicle v where v.fabricationYear = :fabrication_year")
    List<PlateBrand> getPlateAndBrandByYear(@Param("fabrication_year") Integer year);
    // List<Vehicle> getAll();
}
