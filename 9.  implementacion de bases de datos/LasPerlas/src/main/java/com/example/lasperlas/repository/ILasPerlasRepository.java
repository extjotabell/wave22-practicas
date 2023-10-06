package com.example.lasperlas.repository;

import com.example.lasperlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILasPerlasRepository extends JpaRepository<Joya, Long> {
    @Query("SELECT j FROM Joya j WHERE j.enVenta = :enVentaValue")
    List<Joya> findByEnVenta(@Param("enVentaValue") boolean enVenta);
}
