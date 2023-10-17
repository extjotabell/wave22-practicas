package com.example.movies.repository;

import com.example.movies.model.Serie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends CrudRepository<Serie, Integer> {
    List<Serie> findBySeasonsGreaterThan(int seasons);
}
