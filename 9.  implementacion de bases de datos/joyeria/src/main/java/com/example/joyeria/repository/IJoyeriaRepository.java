package com.example.joyeria.repository;

import com.example.joyeria.entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IJoyeriaRepository extends JpaRepository<Joya,Long> {
    @Query("SELECT j FROM Joya j WHERE j.ventaONo = true")
    List<Joya> findAllVentaONo();
}

