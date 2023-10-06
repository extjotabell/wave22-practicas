package com.example.lasperlas.repository;

import com.example.lasperlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JoyaRepository extends JpaRepository<Joya, Long> {

    List<Joya> findByVentaONoIsTrue();
}
