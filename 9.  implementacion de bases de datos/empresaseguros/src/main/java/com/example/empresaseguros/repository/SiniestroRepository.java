package com.example.empresaseguros.repository;

import com.example.empresaseguros.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SiniestroRepository extends JpaRepository<Siniestro, Integer> {
}
