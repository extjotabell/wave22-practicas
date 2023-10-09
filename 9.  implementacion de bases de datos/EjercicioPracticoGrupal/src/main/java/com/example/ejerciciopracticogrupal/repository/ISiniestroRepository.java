package com.example.ejerciciopracticogrupal.repository;

import com.example.ejerciciopracticogrupal.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
}
