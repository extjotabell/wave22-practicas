package com.movies.demoHQL.repository;

import com.movies.demoHQL.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Integer> {
    @Query("FROM Siniestro s")
    List<Siniestro> obtenerTodosSiniestros();
}
