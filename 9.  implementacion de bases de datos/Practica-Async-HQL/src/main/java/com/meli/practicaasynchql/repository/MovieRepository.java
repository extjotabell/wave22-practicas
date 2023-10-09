package com.meli.practicaasynchql.repository;

import com.meli.practicaasynchql.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository  extends JpaRepository<Movie, Long> {
}
