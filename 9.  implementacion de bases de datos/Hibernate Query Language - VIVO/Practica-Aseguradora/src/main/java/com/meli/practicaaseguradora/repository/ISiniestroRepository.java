package com.meli.practicaaseguradora.repository;

import com.meli.practicaaseguradora.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestroRepository extends JpaRepository<Siniestro,Long> {
}
